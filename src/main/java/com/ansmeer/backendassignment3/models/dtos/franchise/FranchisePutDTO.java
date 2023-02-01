package com.ansmeer.backendassignment3.models.dtos.franchise;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FranchisePutDTO {
    private int id;
    private String name;
    private String description;
}