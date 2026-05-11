package com.samuel.biblioteca;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

// o "T" é o que será substituido pelo tipo de dado usado no metodo
public class ApiResponse<T> {

    String message;
    T data;
    int cod;

    public static <T>ApiResponse<T>sucess(T data,String message,int cod){
        return new ApiResponse<>();


    }

}
