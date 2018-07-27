package com.cine.schedule.service;

import com.cine.schedule.entity.Schedule;

import java.util.List;

public interface IScheduleService {

    List<Schedule> getAll();

    void save(Schedule schedule);
}
