package com.ansmeer.backendassignment3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ElementNotFoundException extends NoSuchElementException {

    public ElementNotFoundException(int id, String elementClass) {
        super("No " + elementClass + " was found with id " + id);
    }
}
