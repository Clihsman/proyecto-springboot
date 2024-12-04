package com.drive.modules.roster.workSchedule.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.modules.roster.workSchedule.controller.request.RequestWorkSchedule;
import com.drive.modules.roster.workSchedule.service.WorkScheduleService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/roster/work-schedule")
@RequiredArgsConstructor
public class WorkScheduleController {

    private final WorkScheduleService service;

    @PostMapping
    public void createWorkSchedule(HttpServletRequest request, @RequestBody RequestWorkSchedule workSchedule) {
        Integer userId = (Integer) request.getAttribute("userId");
        service.createWorkSchedule(userId, workSchedule.categoryId(), workSchedule.scheduleType());
    }

}
