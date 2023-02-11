package com.teambuganvilles.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductosNotFoundException extends Exception{
    public ProductosNotFoundException(String producto){
        super(String.format("No item were found for id : %s", producto));
    }
}
