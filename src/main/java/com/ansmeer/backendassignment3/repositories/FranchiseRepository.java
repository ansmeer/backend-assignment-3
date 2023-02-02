package com.ansmeer.backendassignment3.repositories;

import com.ansmeer.backendassignment3.models.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Encapsulates access to franchises stored in the MovieDb.
 */
@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {
}
