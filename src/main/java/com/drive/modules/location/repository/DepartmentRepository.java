package com.drive.modules.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drive.modules.location.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
