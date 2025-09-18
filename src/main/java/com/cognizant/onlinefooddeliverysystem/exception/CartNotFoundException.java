package com.cognizant.onlinefooddeliverysystem.exception;

public class CartNotFoundException extends RuntimeException {
  public CartNotFoundException(String message) {
    super(message);
  }
}
