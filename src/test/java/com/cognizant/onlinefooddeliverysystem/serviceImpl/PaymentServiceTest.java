package com.cognizant.onlinefooddeliverysystem.serviceImpl;

import com.cognizant.onlinefooddeliverysystem.constant.PaymentConstants;
import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentCallbackDTO;
import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentRequestDTO;
import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentResponseDTO;
import com.cognizant.onlinefooddeliverysystem.dto.payment.PaymentStatusDTO;
import com.cognizant.onlinefooddeliverysystem.exception.payment.PaymentException;
import com.cognizant.onlinefooddeliverysystem.model.Order;
import com.cognizant.onlinefooddeliverysystem.model.Payment;
import com.cognizant.onlinefooddeliverysystem.repository.OrderRepository;
import com.cognizant.onlinefooddeliverysystem.repository.PaymentRepository;
import com.cognizant.onlinefooddeliverysystem.service.PaymentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {


    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private PaymentService paymentService;

    private Order order;
    private PaymentRequestDTO paymentRequestDTO;




    @BeforeEach
    void setUp() {
        order = new Order();
        order.setOrderId(1);
        order.setTotalAmount(new BigDecimal("100.00"));
        order.setPayments(new HashSet<>());

        paymentRequestDTO = new PaymentRequestDTO();
        paymentRequestDTO.setOrderId(1);
        paymentRequestDTO.setPaymentMethod("Credit Card");
    }


    //------------------------------------------
    // Tests for initiatePayment()
    //------------------------------------------

    @Test
    void testInitiatePayment_Success() {
        // Arrange
        when(orderRepository.findOrderByOrderId(1)).thenReturn(Optional.of(order));

        Payment savedPayment = new Payment();
        savedPayment.setPaymentId(101);
        savedPayment.setOrder(order);
        savedPayment.setPaymentStatus("Pending");
        when(paymentRepository.save(any(Payment.class))).thenReturn(savedPayment);

        PaymentResponseDTO expectedResponse = new PaymentResponseDTO();
        expectedResponse.setPaymentId(101);
        when(modelMapper.map(savedPayment, PaymentResponseDTO.class)).thenReturn(expectedResponse);

        // Act
        PaymentResponseDTO actualResponse = paymentService.initiatePayment(paymentRequestDTO);

        // Assert
        Assertions.assertNotNull(actualResponse);
        Assertions.assertEquals(101, actualResponse.getPaymentId());

        ArgumentCaptor<Payment> paymentCaptor = ArgumentCaptor.forClass(Payment.class);
        verify(paymentRepository).save(paymentCaptor.capture());
        Payment capturedPayment = paymentCaptor.getValue();

        Assertions.assertEquals("Pending", capturedPayment.getPaymentStatus());
        Assertions.assertEquals(new BigDecimal("100.00"), capturedPayment.getAmount());
        Assertions.assertEquals("Credit Card", capturedPayment.getMethod());
        Assertions.assertEquals(order, capturedPayment.getOrder());

        verify(orderRepository, times(1)).findOrderByOrderId(1);
        verify(modelMapper, times(1)).map(any(), eq(PaymentResponseDTO.class));
    }


    @Test
    void testInitiatePayment_ThrowsPaymentException_WhenOrderNotFound() {
        // Arrange
        when(orderRepository.findOrderByOrderId(99)).thenReturn(Optional.empty());
        paymentRequestDTO.setOrderId(99);

        // Act & Assert
        PaymentException exception = Assertions.assertThrows(PaymentException.class, () -> {
            paymentService.initiatePayment(paymentRequestDTO);
        });
        Assertions.assertEquals("Order not Found with ID: 99", exception.getMessage());
        verifyNoInteractions(paymentRepository, modelMapper);
    }


    @Test
    void testInitiatePayment_ThrowsPaymentException_WhenPaymentAlreadySuccessful() {
        // Arrange
        Payment successfulPayment = new Payment();
        successfulPayment.setPaymentStatus("Successful");
        order.getPayments().add(successfulPayment);
        when(orderRepository.findOrderByOrderId(1)).thenReturn(Optional.of(order));

        // Act & Assert
        PaymentException exception = Assertions.assertThrows(PaymentException.class, () -> {
            paymentService.initiatePayment(paymentRequestDTO);
        });
        Assertions.assertEquals("Payment for order Id : 1 is already successful.", exception.getMessage());
    }


    @Test
    void testInitiatePayment_ThrowsPaymentException_WhenPaymentAlreadyPending() {
        // Arrange
        Payment pendingPayment = new Payment();
        pendingPayment.setPaymentStatus("Pending");
        order.getPayments().add(pendingPayment);
        when(orderRepository.findOrderByOrderId(1)).thenReturn(Optional.of(order));

        // Act & Assert
        PaymentException exception = Assertions.assertThrows(PaymentException.class, () -> {
            paymentService.initiatePayment(paymentRequestDTO);
        });
        Assertions.assertEquals("Payment for order Id : 1 is already pending.", exception.getMessage());
    }

    //------------------------------------------
    // Tests for processPaymentResponse()
    //------------------------------------------

    @Test
    void testProcessPaymentResponse_Success() {
        // Arrange
        Payment pendingPayment = new Payment();
        pendingPayment.setPaymentId(101);
        pendingPayment.setPaymentStatus("Pending");
        when(paymentRepository.findById(101)).thenReturn(Optional.of(pendingPayment));

        PaymentCallbackDTO callback = new PaymentCallbackDTO(101, "Credit Card", "1234-5678", 123, 100.0f);

        // Setting up mocks
        try (MockedStatic<PaymentConstants> mockedConstants = mockStatic(PaymentConstants.class)) {
            mockedConstants.when(() -> PaymentConstants.validatePayment(
                    "Credit Card", "1234-5678", 123, 100.0f
            )).thenReturn(true);

            // Act
            String transactionId = paymentService.processPaymentResponse(callback);

            // Assert
            Assertions.assertNotNull(transactionId);
            Assertions.assertTrue(transactionId.startsWith("txn_"));

            ArgumentCaptor<Payment> paymentCaptor = ArgumentCaptor.forClass(Payment.class);
            verify(paymentRepository).save(paymentCaptor.capture());
            Payment capturedPayment = paymentCaptor.getValue();

            Assertions.assertEquals("Successful", capturedPayment.getPaymentStatus());
            Assertions.assertEquals(transactionId, capturedPayment.getTransactionId());
        }
    }

    @Test
    void testProcessPaymentResponse_Failed() {
        // Arrange
        Payment pendingPayment = new Payment();
        pendingPayment.setPaymentId(101);
        pendingPayment.setPaymentStatus("Pending");
        when(paymentRepository.findById(101)).thenReturn(Optional.of(pendingPayment));

        PaymentCallbackDTO callback = new PaymentCallbackDTO(101, "Debit Card", "invalid-card", 1000, 50.0f);

        try (MockedStatic<PaymentConstants> mockedConstants = mockStatic(PaymentConstants.class)) {
            mockedConstants.when(() -> PaymentConstants.validatePayment(
                    "Debit Card", "invalid-card", 1000, 50.0f
            )).thenReturn(false);

            // Act
            String transactionId = paymentService.processPaymentResponse(callback);

            // Assert
            Assertions.assertNotNull(transactionId);

            ArgumentCaptor<Payment> paymentCaptor = ArgumentCaptor.forClass(Payment.class);
            verify(paymentRepository).save(paymentCaptor.capture());
            Payment capturedPayment = paymentCaptor.getValue();

            Assertions.assertEquals("Failed", capturedPayment.getPaymentStatus());
            Assertions.assertEquals(transactionId, capturedPayment.getTransactionId());
        }
    }

    @Test
    void testProcessPaymentResponse_ThrowsPaymentException_WhenPaymentNotFound() {
        // Arrange
        when(paymentRepository.findById(999)).thenReturn(Optional.empty());
        PaymentCallbackDTO callback = new PaymentCallbackDTO(999, "UPI", "test@upi", null, 1.0f);

        // Act & Assert
        PaymentException exception = Assertions.assertThrows(PaymentException.class, () -> {
            paymentService.processPaymentResponse(callback);
        });
        Assertions.assertEquals("Payment not found with ID: 999", exception.getMessage());
    }

    //------------------------------------------
    // Tests for getPaymentStatus()
    //------------------------------------------

    @Test
    void testGetPaymentStatus_ReturnsStatusList() {
        // Arrange
        Integer orderId = 1;
        Payment p1 = new Payment();
        p1.setPaymentStatus("Successful");
        p1.setTransactionId("txn_123");
        p1.setOrder(order);

        Payment p2 = new Payment();
        p2.setPaymentStatus("Failed");
        p2.setTransactionId("txn_456");
        p2.setOrder(order);

        List<Payment> paymentList = Arrays.asList(p1, p2);
        when(paymentRepository.findAllByOrder_OrderId(orderId)).thenReturn(paymentList);

        // Act
        List<PaymentStatusDTO> statusDTOs = paymentService.getPaymentStatus(orderId);

        // Assert
        Assertions.assertNotNull(statusDTOs);
        Assertions.assertEquals(2, statusDTOs.size());

        Assertions.assertEquals(orderId, statusDTOs.get(0).getOrderId());
        Assertions.assertEquals("Successful", statusDTOs.get(0).getPaymentStatus());
        Assertions.assertEquals("txn_123", statusDTOs.get(0).getTransactionId());

        Assertions.assertEquals(orderId, statusDTOs.get(1).getOrderId());
        Assertions.assertEquals("Failed", statusDTOs.get(1).getPaymentStatus());
        Assertions.assertEquals("txn_456", statusDTOs.get(1).getTransactionId());
    }


    @Test
    void testGetPaymentStatus_ReturnsEmptyList_WhenNoPaymentsFound() {
        // Arrange
        Integer orderId = 2;
        when(paymentRepository.findAllByOrder_OrderId(orderId)).thenReturn(Collections.emptyList());

        // Act
        List<PaymentStatusDTO> statusDTOs = paymentService.getPaymentStatus(orderId);

        // Assert
        Assertions.assertNotNull(statusDTOs);
        Assertions.assertTrue(statusDTOs.isEmpty());
    }




}
