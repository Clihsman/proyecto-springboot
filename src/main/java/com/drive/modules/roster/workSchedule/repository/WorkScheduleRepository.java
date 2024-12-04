package com.drive.modules.roster.workSchedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drive.modules.roster.workSchedule.model.WorkSchedule;

public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Integer> {

}
