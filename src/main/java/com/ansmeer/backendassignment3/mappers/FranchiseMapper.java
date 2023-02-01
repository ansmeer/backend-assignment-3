package com.ansmeer.backendassignment3.mappers;

import com.ansmeer.backendassignment3.models.Franchise;
import com.ansmeer.backendassignment3.models.dtos.franchise.FranchiseGetDTO;
import com.ansmeer.backendassignment3.models.dtos.franchise.FranchisePostDTO;
import com.ansmeer.backendassignment3.models.dtos.franchise.FranchisePutDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {
    /**
     * Converts a Franchise entity into a FranchiseGetDTO.
     *
     * @param franchise the Franchise entity
     * @return the FranchiseGetDTO
     */
    FranchiseGetDTO franchiseToFranchiseGetDto(Franchise franchise);

    /**
     * Converts a list of Franchise entities to a list of FranchiseGetDTOs.
     *
     * @param franchise the Franchise entity
     * @return the list of FranchiseGetDTOs
     */
    List<FranchiseGetDTO> franchiseToFranchiseGetDto(List<Franchise> franchise);

    /**
     * Converts a FranchisePostDTO to a Franchise entity.
     *
     * @param franchise the FranchisePostDTO
     * @return the Franchise entity
     */
    Franchise franchisePostDtoToFranchise(FranchisePostDTO franchise);

    /**
     * Converts a FranchisePutDTO to a Franchise entity.
     *
     * @param franchise the FranchisePutDTO
     * @return the Franchise entity
     */
    Franchise franchisePutDtoToFranchise(FranchisePutDTO franchise);
}