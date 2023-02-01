package com.ansmeer.backendassignment3.models.dtos.franchise;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is a DTO to represent the Franchise entity, for example in post endpoints.
 * It includes all non-nullable fields.
 */
@Getter
@Setter
public class FranchisePostDTO {
    private String name;
}