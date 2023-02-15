package com.teambuganvilles.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UsuarioNotFoundException extends Exception{
    public UsuarioNotFoundException(int id){
        super(String.format("No item were found for id : %s", id));
    }
}




