import java.util.HashMap;
import java.util.Map;

public class HumanScheduleDay {

    private Map<String, DayOfWeek> dayOfWeekMap;
    private Map<String, Task> taskMap;

    enum DayOfWeek {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    enum Task {
        EAT,
        SLEEP,
        REST,
        STUDY,
        WORKOUT,
        COOK,
        PRAY
    }

    public HumanScheduleDay() {
        this.dayOfWeekMap = new HashMap<>();
        this.taskMap = new HashMap<>();
    }

    public void addDayOfWeek(String key, DayOfWeek day) {
        this.dayOfWeekMap.put(key, day);
    }

    public void addTask(String key, Task task) {
        this.taskMap.put(key, task);
    }

    public DayOfWeek getDayOfWeek(String key) {
        return this.dayOfWeekMap.get(key);
    }

    public Task getTask(String key) {
        return this.taskMap.get(key);
    }

    public void setScheduleDay(String day, String task) {
        this.dayOfWeekMap.put(day, DayOfWeek.valueOf(day.toUpperCase()));
        this.taskMap.put(task, Task.valueOf(task.toUpperCase()));
    }

    public void removeDayOfWeek(String key) {
        this.dayOfWeekMap.remove(key);
    }

    public void removeTask(String key) {
        this.taskMap.remove(key);
    }

    public Map<String, DayOfWeek> getDayOfWeekMap() {
        return dayOfWeekMap;
    }

    public Map<String, Task> getTaskMap() {
        return taskMap;
    }

    @Override
    public String toString() {
        return "HumanScheduleDay{" +
                "dayOfWeekMap=" + dayOfWeekMap +
                ", taskMap=" + taskMap +
                '}';
    }
}