package com.teambuganvilles.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VentasNotFoundException extends Exception{
    public VentasNotFoundException(int id_venta){
        super(String.format("No item were found for id : %s", id_venta));
    }
}
