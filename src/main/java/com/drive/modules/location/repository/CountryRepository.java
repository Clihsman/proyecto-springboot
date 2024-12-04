package com.drive.modules.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drive.modules.location.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>  {
    
}
