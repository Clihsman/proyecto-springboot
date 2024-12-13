package com.drive.modules.customers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.drive.modules.customers.controller.request.CustomerRequest;
import com.drive.modules.customers.model.Customer;
import com.drive.modules.customers.repository.CustomerRepository;
import com.drive.modules.parameters.educationalLevels.model.EducationalLevel;
import com.drive.modules.parameters.educationalLevels.repository.EducationalLevelRepository;
import com.drive.modules.parameters.institutions.model.Institution;
import com.drive.modules.parameters.institutions.repository.InstitutionRepository;
import com.drive.modules.parameters.specialties.model.Specialty;
import com.drive.modules.parameters.specialties.repository.SpecialtyRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final InstitutionRepository institutionRepository;
    private final SpecialtyRepository specialtyRepository;
    private final EducationalLevelRepository educationalLevelRepository;

    public Customer createCustomer(CustomerRequest customer) {

        Optional<Institution> institution = institutionRepository.findById(customer.institution());
        
        Optional<Specialty> specialty = specialtyRepository
        .findById(customer.speciality());

        Optional<EducationalLevel> educationalLevel = educationalLevelRepository
                .findById(customer.educationalLevel());

        Customer newCustomer = Customer.builder()
        .firstName(customer.firstName())
        .middleName(customer.middleName())
        .firstSurname(customer.firstSurname())
        .secondLastName(customer.secondLastName())
        .documentNumber(customer.documentNumber())
        .email(customer.email())
        .address(customer.address())
        .phone(customer.phone())
        .sex(customer.sex())
        .institution(institution.get())
        .specialty(specialty.get())
        .educationalLevel(educationalLevel.get())
        .build();
        
        return customerRepository.save(newCustomer);
    }

    public void deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    public Optional<Customer> updateCustomer(CustomerRequest requestCustomer) {
        Optional<Customer> wantedCustomer = customerRepository.findByEmail(requestCustomer.email());

        if (!wantedCustomer.isPresent())
            return Optional.empty();

        Customer updateCustomer = wantedCustomer.get();

        Optional<Institution> institution = institutionRepository.findById(requestCustomer.institution());
        Optional<Specialty> specialty = specialtyRepository
        .findById(requestCustomer.speciality());
        Optional<EducationalLevel> educationalLevel = educationalLevelRepository
                .findById(requestCustomer.educationalLevel());

        updateCustomer.setFirstName(requestCustomer.firstName());
        updateCustomer.setMiddleName(requestCustomer.middleName());
        updateCustomer.setFirstName(requestCustomer.firstSurname());
        updateCustomer.setSecondLastName(requestCustomer.secondLastName());
        updateCustomer.setDocumentNumber(requestCustomer.documentNumber());
        updateCustomer.setAddress(requestCustomer.address());
        updateCustomer.setEmail(requestCustomer.email());
        updateCustomer.setPhone(requestCustomer.phone());
        updateCustomer.setSex(requestCustomer.sex());
        updateCustomer.setInstitution(institution.get());
        updateCustomer.setSpecialty(specialty.get());
        updateCustomer.setEducationalLevel(educationalLevel.get());

        return Optional.of(customerRepository.save(updateCustomer));
    }

    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
}
