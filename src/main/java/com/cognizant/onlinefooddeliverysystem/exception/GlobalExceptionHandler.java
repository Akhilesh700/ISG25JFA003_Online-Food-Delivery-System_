package com.cognizant.onlinefooddeliverysystem.exception;

import com.cognizant.onlinefooddeliverysystem.dto.error.ErrorResponse;
import com.cognizant.onlinefooddeliverysystem.exception.login.NoUsersFoundWithUsername;
import com.cognizant.onlinefooddeliverysystem.exception.login.WrongCredentialsException;
import com.cognizant.onlinefooddeliverysystem.exception.menu.RestaurantNotFoundException;
import com.cognizant.onlinefooddeliverysystem.exception.order.CartItemNotFoundWithCartIdException;
import com.cognizant.onlinefooddeliverysystem.exception.order.UserHasNoRoleException;
import com.cognizant.onlinefooddeliverysystem.exception.payment.CartNotFoundException;
import com.cognizant.onlinefooddeliverysystem.exception.payment.InvalidPaymentTypeException;
import com.cognizant.onlinefooddeliverysystem.exception.payment.InvalidPaymentTypePinException;
import com.cognizant.onlinefooddeliverysystem.exception.payment.PaymentException;
import com.cognizant.onlinefooddeliverysystem.exception.signup.UserAlreadyExistsException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED) // Sets the HTTP response status to 401
    public Map<String, String> handleBadCredentialsException(BadCredentialsException ex) {

        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("status", "401");
        errorResponse.put("error", "Unauthorized");
        errorResponse.put("message", "Invalid username or password");

        return errorResponse;
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "User Conflict",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(NoUsersFoundWithUsername.class)
        public ResponseEntity<ErrorResponse> handleNoUsersFoundWithUsername(NoUsersFoundWithUsername ex) {
            ErrorResponse errorResponse = new ErrorResponse(
                    HttpStatus.CONFLICT.value(),
                    "User not found",
                    ex.getMessage()
            );
            return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
        }

    // This handler for the specific exception should be before the more generic handler
    @ExceptionHandler(WrongCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleWrongCredentialsException(WrongCredentialsException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.UNAUTHORIZED.value(), // Use 401 Unauthorized for wrong credentials
                "Wrong Credentials",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(UserHasNoRoleException.class)
    public ResponseEntity<ErrorResponse> handleUserHasNoRoleException(UserHasNoRoleException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(), // Use 401 Unauthorized for wrong credentials
                "Wrong Credentials",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(CartItemNotFoundWithCartIdException.class)
    public ResponseEntity<ErrorResponse> handleCartItemNotFoundException(CartItemNotFoundWithCartIdException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Not found",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MenuItemNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMenuItemNotFoundException(MenuItemNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Not found",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRestaurantNotFoundException(RestaurantNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Not found",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Payment Exceptions
    @ExceptionHandler(PaymentException.class)
    public ResponseEntity<ErrorResponse> handlePaymentException(PaymentException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                "Payment Conflict",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidPaymentTypePinException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPaymentTypePinException(InvalidPaymentTypePinException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_ACCEPTABLE.value(),
                "Incorrect PIN",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPaymentTypeException.class)
    public ResponseEntity<ErrorResponse> handleInvalidPaymentTypeException(InvalidPaymentTypeException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_ACCEPTABLE.value(),
                "Incorrect Credentials",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyCartException.class)
    public ResponseEntity<ErrorResponse> handleEmptyCartException(EmptyCartException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Cart not found",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCartNotFoundException(CartNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Cart not found",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String, String> handleExpiredJwtException(ExpiredJwtException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("status", "401");
        errorResponse.put("error", "Unauthorized");
        errorResponse.put("message", "JWT has expired. Please login again.");
        return errorResponse;
    }

    @ExceptionHandler(MalformedJwtException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String, String> handleMalformedJwtException(MalformedJwtException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("status", "401");
        errorResponse.put("error", "Unauthorized");
        errorResponse.put("message", "Invalid JWT token.");
        return errorResponse;
    }

    @ExceptionHandler(OnlineFoodDeliveryAppException.class)
    public ResponseEntity<ErrorResponse> handleOnlineFoodDeliveryAppException(OnlineFoodDeliveryAppException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Application Error",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected error occurred",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}