package com.drive.modules.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drive.modules.location.model.City;

public interface CityRepository extends JpaRepository<City, Integer> {
    
}
