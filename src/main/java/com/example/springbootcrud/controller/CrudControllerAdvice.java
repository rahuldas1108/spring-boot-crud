package com.example.springbootcrud.controller;

import com.example.springbootcrud.exception.ErrorResponse;
import com.example.springbootcrud.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CrudControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex){

        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setErrorCode("404");
        errorResponse.setErrorMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class ,IllegalArgumentException.class})
    public ResponseEntity<ErrorResponse> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException ex){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setErrorCode("400");
        errorResponse.setErrorMessage("Please verify the uri and the request mapping. Error : "+ex.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
