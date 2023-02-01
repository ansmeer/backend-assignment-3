package com.ansmeer.backendassignment3.mappers;

import com.ansmeer.backendassignment3.models.Franchise;
import com.ansmeer.backendassignment3.models.dtos.franchise.FranchiseGetDTO;
import com.ansmeer.backendassignment3.models.dtos.franchise.FranchisePostDTO;
import com.ansmeer.backendassignment3.models.dtos.franchise.FranchisePutDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {
    FranchiseGetDTO franchiseToFranchiseGetDto(Franchise franchise);

    List<FranchiseGetDTO> franchiseToFranchiseGetDto(List<Franchise> franchise);

    Franchise franchisePostDtoToFranchise(FranchisePostDTO franchise);

    Franchise franchisePutDtoToFranchise(FranchisePutDTO franchise);
}