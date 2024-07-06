// Main.java
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DailyPlanner planner = new DailyPlanner();

        try {
            planner.addActivity(Day.MONDAY, "Gym");
            planner.addActivity(Day.MONDAY, "Work");

            planner.addActivity(Day.TUESDAY, "Yoga");

            planner.removeActivity(Day.MONDAY, "Work");

            List<String> mondayActivities = planner.getActivities(Day.MONDAY);
            System.out.println("Monday Activities: " + mondayActivities);

            Map<Day, List<String>> allActivities = planner.endPlanning();
            System.out.println("All Activities: " + allActivities);
        } catch (NoActivityException e) {
            System.err.println(e.getMessage());
        } catch (NoActivitiesForDayException e) {
            System.err.println(e.getMessage());
        }
    }
}
