package com.cognizant.onlinefooddeliverysystem.service.implimentation;

import com.cognizant.onlinefooddeliverysystem.dto.order.GetOrderHistoryResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.order.PlaceOrderRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.order.PlaceOrderResponseDto;
import com.cognizant.onlinefooddeliverysystem.dto.order.UpdatePaymentRequestDto;
import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentResponseDTO;
import com.cognizant.onlinefooddeliverysystem.exception.MenuItemNotFoundException;
import com.cognizant.onlinefooddeliverysystem.exception.ResourceNotFoundException;
import com.cognizant.onlinefooddeliverysystem.exception.order.CartItemNotFoundWithCartIdException;
import com.cognizant.onlinefooddeliverysystem.exception.payment.PaymentException;
import com.cognizant.onlinefooddeliverysystem.model.*;
import com.cognizant.onlinefooddeliverysystem.repository.*;
import com.cognizant.onlinefooddeliverysystem.service.OrderService;
import com.cognizant.onlinefooddeliverysystem.util.GetVerifiedUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final StatusRepository statusRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderItemRepository orderItemRepository;
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    private final GetVerifiedUser getVerifiedUser;
    private final MenuItemRepository menuItemRepository;
    private PaymentRepository paymentRepository;

    private Order createOrder(Cart cart, List<CartItem> cartItems, Status placedStatus, PlaceOrderRequestDto request){
        Order newOrder = new Order();
        newOrder.setCustomer(cart.getCustomer());
        newOrder.setRestaurant(cartItems.getFirst().getMenuItems().getRestaurant());
        newOrder.setStatus(placedStatus);
        newOrder.setTotalAmount(BigDecimal.valueOf(cart.getTotalPrice()));
        newOrder.setSpecialReq(request.getNote());
        return orderRepository.save(newOrder);
    }

    private List<OrderItem> mapOrderItems(List<CartItem> cartItems, Order placedOrder){
        return cartItems.stream().map(cartItem -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(placedOrder);
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getPrice());
            orderItem.setMenuItems(cartItem.getMenuItems());
            return orderItem;
        } ).toList();
    }

    @Override
    @Transactional
    public PlaceOrderResponseDto placeOrderByCartId(PlaceOrderRequestDto request) {

            User user = getVerifiedUser.getVerifiedUser();
            Customer customer = customerRepository.findByUser_UserId(user.getUserId());
            Cart cart = cartRepository.findCartByCustId(customer.getCustId())
                    .orElseThrow(() -> new ResourceNotFoundException("Cart not found for User id : " + user.getUserId() + " with customer id : " + customer.getCustId()));

            List<CartItem> cartItems = cartItemRepository.findByCartId(cart.getId());
            if(cartItems.isEmpty()){
                throw new CartItemNotFoundWithCartIdException("Empty cart with id : " + cart.getId());
            }
            Status placedStatus = statusRepository.findByStatusType(Status.StatusType.PENDING)
                    .orElseThrow(() -> new ResourceNotFoundException("Status 'PENDING' not found."));

//            Step 1 : Creation of order
            Order placedOrder = createOrder(cart, cartItems, placedStatus, request);
//            Step 2 : Mapping list of cartItems

            List<OrderItem> orderedItems = mapOrderItems(cartItems, placedOrder);
//          Step 3 : Saving the list of ordered items to database
            orderItemRepository.saveAll(orderedItems);

//            Step 4 : Deleting cart items after the order is placed
            int rowsAffected = cartItemRepository.deleteCartItemsByCartId(cart.getId());
//            Step 5 : Making the cart empty || Resetting the cart
            cartRepository.resetCartById(cart.getId());

        return new PlaceOrderResponseDto(
                placedOrder.getOrderId(),
                rowsAffected,
                "Order placed successfully!"
        );
    }

    @Override
    public List<GetOrderHistoryResponseDto> getOrderHistoryByCustomerId() {
        User user = getVerifiedUser.getVerifiedUser();
        Customer customer = customerRepository.findByUser_UserId(user.getUserId());

        List<Order> orders = orderRepository.findByCustomer_CustId(customer.getCustId());
        return orders.stream().map(order -> {
            List<OrderItem> orderedItems = orderItemRepository.findByOrder_OrderId(order.getOrderId());
//           Getting list of menu items mapped with order item
            List<MenuItems> menuItems = orderedItems.stream().map((orderItem ->
                menuItemRepository.findById((int) orderItem.getMenuItems().getItemId()).orElseThrow(() ->
                        new MenuItemNotFoundException("Menu Item is not found by Menu Item Id : " + orderItem.getMenuItems().getItemId())
                )
            )).toList();

            return new GetOrderHistoryResponseDto(
                    order.getOrderId(),
                    menuItems.getFirst().getRestaurant().getName(),
                    menuItems.getFirst().getRestaurant().getAddress(),
                    order.getTotalAmount(),
                    orderedItems,
                    order.getStatus().getStatusType().toString(),
                    order.getSpecialReq()
            );
        }).toList();
    }

    @Override
    public void updateOrderPaymentStatus(Integer orderId, UpdatePaymentRequestDto request){
        Order order = orderRepository.findOrderByOrderId(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with ID: " + orderId));

        Set<Payment> payments = order.getPayments();

        if (payments.stream().anyMatch(p -> p.getPaymentStatus() == Payment.Status.Successful )) {
            throw new PaymentException("Payment for order Id : " + order.getOrderId() + " is already successful.");
        }else {
            Payment payment = new Payment();
            payment.setOrder(order);
            payment.setAmount(BigDecimal.valueOf(request.getAmount()));
            payment.setMethod("Online");
            payment.setPaymentStatus(request.getStatus());
            payment.setPaymentType("Pre_Paid");
            payment.setTransactionId(request.getPaymentId());
            payment.setTimestamp(LocalDateTime.now());

            payments.add(payment);
            Status status = statusRepository.findByStatusType(Status.StatusType.valueOf("PLACED"))
                    .orElseThrow(() -> new ResourceNotFoundException("Not_Accepted Status Not Found"));
            order.setStatus(status);
            orderRepository.save(order);
        }
    }
}