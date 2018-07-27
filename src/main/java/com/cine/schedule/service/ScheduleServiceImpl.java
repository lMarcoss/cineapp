package com.cine.schedule.service;

import com.cine.schedule.entity.Schedule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements IScheduleService {

    List<Schedule> listSchedules;

    public ScheduleServiceImpl() {
        this.listSchedules = new ArrayList<>();
    }

    @Override
    public List<Schedule> getAll() {
        return listSchedules;
    }

    @Override
    public void save(Schedule schedule) {
        listSchedules.add(schedule);
    }
}
