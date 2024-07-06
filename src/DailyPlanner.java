import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyPlanner {
    private List<DaySchedule> daySchedules;

    public DailyPlanner() {
        this.daySchedules = new ArrayList<>();
        for (Day day : Day.values()) {
            daySchedules.add(new DaySchedule(day));
        }
    }

    public void addActivity(Day day, String activity) {
        if (activity == null) {
            throw new NoActivityException("Activity cannot be null");
        }
        for (DaySchedule schedule : daySchedules) {
            if (schedule.getDay() == day) {
                schedule.addActivity(activity);
                return;
            }
        }
    }

    public void removeActivity(Day day, String activity) {
        for (DaySchedule schedule : daySchedules) {
            if (schedule.getDay() == day) {
                if (!schedule.getActivities().contains(activity)) {
                    throw new NoActivityException("Activity does not exist");
                }
                schedule.removeActivity(activity);
                return;
            }
        }
    }

    public List<String> getActivities(Day day) {
        for (DaySchedule schedule : daySchedules) {
            if (schedule.getDay() == day) {
                return schedule.getActivities();
            }
        }
        return new ArrayList<>();
    }

    public Map<Day, List<String>> endPlanning() throws NoActivitiesForDayException {
        Map<Day, List<String>> map = new HashMap<>();
        for (DaySchedule schedule : daySchedules) {
            if (schedule.getActivities().isEmpty()) {
                throw new NoActivitiesForDayException("No activities for " + schedule.getDay());
            }
            map.put(schedule.getDay(), schedule.getActivities());
        }
        return map;
    }
}
