package com.cognizant.onlinefooddeliverysystem.exception.menu;

public class RestaurantNotFoundException extends RuntimeException {
  public RestaurantNotFoundException(String message) {
    super(message);
  }
}
