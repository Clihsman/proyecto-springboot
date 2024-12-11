package com.drive.modules.parameters.institutions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.drive.modules.location.model.City;
import com.drive.modules.location.repository.CityRepository;
import com.drive.modules.parameters.institutions.controller.request.InstitutionRequest;
import com.drive.modules.parameters.institutions.model.Institution;
import com.drive.modules.parameters.institutions.repository.InstitutionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InstitutionService {
    private final InstitutionRepository institutionRepository;
    private final CityRepository cityRepository;

    public List<Institution> getAllInstitutions() {
        return institutionRepository.findAll();
    }

    public Institution createInstitution(InstitutionRequest institutionRequest) {
        Optional<City> city = cityRepository.findById(institutionRequest.cityId());

        Institution institution = Institution
                .builder()
                .name(institutionRequest.name())
                .address(institutionRequest.address())
                .phone(institutionRequest.phone())
                .email(institutionRequest.email())
                .city(city.isPresent() ? city.get() : null)
                .build();

        return institutionRepository.save(institution);
    }

    public Integer deleteInstitution(int id) {
        return institutionRepository.deleteById(id);
    }
}
