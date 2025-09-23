package com.cognizant.onlinefooddeliverysystem.exception.order;

public class UserHasNoRoleException extends RuntimeException {
  public UserHasNoRoleException(String message) {
    super(message);
  }
}
