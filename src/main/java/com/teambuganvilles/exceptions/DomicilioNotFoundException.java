package com.teambuganvilles.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DomicilioNotFoundException extends Exception {
    public DomicilioNotFoundException(int id_dom ){
        super(String.format("No item were found for id : %s", id_dom));
    }
}
