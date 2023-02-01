package com.ansmeer.backendassignment3.models.dtos.franchise;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is a DTO to represent the Franchise entity, for example in put endpoints.
 * It includes all properties without relationships.
 */
@Getter
@Setter
public class FranchisePutDTO {
    private int id;
    private String name;
    private String description;
}