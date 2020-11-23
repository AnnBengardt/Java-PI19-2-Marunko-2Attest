package services;

import DAO.ScheduleDao;
import models.Schedule;

import java.util.List;

public class ScheduleService {
    private ScheduleDao scheduleDao = new ScheduleDao();

    public ScheduleService(){}

    public Schedule findSchedule(int id){
        return scheduleDao.findById(id);
    }

    public void saveSchedule(Schedule schedule){
        scheduleDao.save(schedule);
    }

    public void updateSchedule(Schedule schedule){
        scheduleDao.update(schedule);
    }

    public void deleteSchedule(Schedule schedule){
        scheduleDao.delete(schedule);
    }

    public List<Schedule> findAllSchedules(){
        return scheduleDao.getAll();
    }

}