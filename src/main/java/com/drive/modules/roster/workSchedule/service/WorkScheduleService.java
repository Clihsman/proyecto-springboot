package com.drive.modules.roster.workSchedule.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.drive.modules.parameters.categories.model.Category;
import com.drive.modules.parameters.categories.repository.CategoryRepository;
import com.drive.modules.roster.workSchedule.model.WorkSchedule;
import com.drive.modules.roster.workSchedule.model.WorkSchedule.WorkScheduleType;
import com.drive.modules.roster.workSchedule.repository.WorkScheduleRepository;
import com.drive.modules.user.model.User;
import com.drive.modules.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkScheduleService {

    private final WorkScheduleRepository repository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public void createWorkSchedule(Integer userId, Integer categoryId, WorkScheduleType scheduleType) {

        Optional<User> user = userRepository.findById(userId);
        Optional<Category> category = categoryRepository.findById(categoryId);

        WorkSchedule schedule = WorkSchedule.builder()
                .user(user.get())
                .category(category.get())
                .type(scheduleType)
                .build();

        repository.save(schedule);
    }
}
