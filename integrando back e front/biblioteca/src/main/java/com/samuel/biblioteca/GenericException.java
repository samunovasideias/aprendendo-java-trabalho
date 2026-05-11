package com.samuel.biblioteca;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericException {

    @ExceptionHandler(Exception.class)
    public static ApiResponse<Object> GenericAdvice(Exception ex){

     ApiResponse<Object> response =new ApiResponse();
        response.setCod(422);
        response.setMessage(ex.getMessage());
        response.setData(null);
        return response;
    }
}
