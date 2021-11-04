package com.example.springbootstarter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {


   @ExceptionHandler(value = ApiRequestException.class)
   public ResponseEntity<Object> handleApiRequestException(ApiRequestException exception) {

      HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;

      ApiException apiException = new ApiException(
         exception.getMessage(),
//         exception
         BAD_REQUEST,
         ZonedDateTime.now(ZoneId.of("Z"))
      );

      return new ResponseEntity<>(apiException, BAD_REQUEST);

   }


   @ExceptionHandler(value = ApiNotFoundException.class)
   public ResponseEntity<Object> handleApiNotFoundException(ApiNotFoundException exception) {

      HttpStatus notFound = HttpStatus.NOT_FOUND;

      ApiException apiException = new ApiException(
         exception.getMessage(),
         notFound,
         ZonedDateTime.now(ZoneId.of("Z"))
      );

      return new ResponseEntity<>(apiException, notFound);

   }

   @ExceptionHandler(value = ApiUpdateConflictException.class)
   public ResponseEntity<Object> handleApiUpdateConflictException(ApiUpdateConflictException exception) {

      HttpStatus conflict = HttpStatus.CONFLICT;

      ApiException apiException = new ApiException(
         exception.getMessage(),
         conflict,
         ZonedDateTime.now(ZoneId.of("Z"))
      );

      return new ResponseEntity<>(apiException, conflict);
   }




}
