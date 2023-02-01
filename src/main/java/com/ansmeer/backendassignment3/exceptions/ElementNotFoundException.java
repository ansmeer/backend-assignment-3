package com.ansmeer.backendassignment3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

/**
 * This class represents an exception to be used when a certain element/entity cannot be found.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ElementNotFoundException extends NoSuchElementException {

    /**
     * Constructs an instance of the ElementNotFoundException
     * to be thrown when an element/entity cannot be found.
     * The HTTP status will automatically be set to code 404.
     *
     * @param id           the id of the element that could not be found
     * @param elementClass the model/class of the element
     */
    public ElementNotFoundException(int id, String elementClass) {
        super("No " + elementClass + " was found with id " + id);
    }
}
