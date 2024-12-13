package com.drive.modules.supplier.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.drive.modules.parameters.educationalLevels.model.EducationalLevel;
import com.drive.modules.parameters.educationalLevels.repository.EducationalLevelRepository;
import com.drive.modules.parameters.specialties.model.Specialty;
import com.drive.modules.parameters.specialties.repository.SpecialtyRepository;
import com.drive.modules.supplier.controller.request.SupplierRequest;
import com.drive.modules.supplier.model.Supplier;
import com.drive.modules.supplier.repository.SupplierRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository repository;
    private final SpecialtyRepository specialtyRepository;
    private final EducationalLevelRepository educationalLevelRepository;

    public List<Supplier> getSuppliers() {
        return repository.findAll();
    }

    public Optional<Supplier> getSupplierById(int id) {
        return repository.findById(id);
    }

    public Supplier createSupplier(SupplierRequest supplier) {       
        Optional<Specialty> specialty = specialtyRepository
        .findById(supplier.speciality());

        Optional<EducationalLevel> educationalLevel = educationalLevelRepository
                .findById(supplier.educationalLevel());

        Supplier newSupplier = Supplier.builder()
        .firstName(supplier.firstName())
        .middleName(supplier.middleName())
        .firstSurname(supplier.firstSurname())
        .secondLastName(supplier.secondLastName())
        .documentNumber(supplier.documentNumber())
        .email(supplier.email())
        .address(supplier.address())
        .phone(supplier.phone())
        .sex(supplier.sex())
        .supportArea(supplier.supportArea())
        .masteredPrograms(supplier.masteredPrograms())
        .specialty(specialty.get())
        .educationalLevel(educationalLevel.get())
        .build();
        
        return repository.save(newSupplier);
    }
}
