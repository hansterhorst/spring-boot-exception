package com.example.springbootstarter.exceptions;

public class ApiUpdateConflictException extends RuntimeException{

   public ApiUpdateConflictException(String message) {
      super(message);
   }
}
