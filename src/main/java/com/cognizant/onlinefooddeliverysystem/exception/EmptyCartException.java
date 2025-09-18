package com.cognizant.onlinefooddeliverysystem.exception;

public class EmptyCartException extends RuntimeException {
  public EmptyCartException(String message) {
    super(message);
  }
}
