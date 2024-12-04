package com.drive.modules.roster.workSchedule.controller.request;

import com.drive.modules.roster.workSchedule.model.WorkSchedule.WorkScheduleType;

public record RequestWorkSchedule(
        Integer categoryId,
        WorkScheduleType scheduleType) {
}
