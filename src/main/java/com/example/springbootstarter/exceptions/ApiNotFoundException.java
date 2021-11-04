package com.example.springbootstarter.exceptions;

public class ApiNotFoundException extends RuntimeException {

   public ApiNotFoundException(String message) {
      super(message);
   }
}
