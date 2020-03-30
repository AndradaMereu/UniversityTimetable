package domain;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Timeslot {

    private DayOfWeek day;
    private LocalTime time;

    public Timeslot(DayOfWeek day, LocalTime time) {
        this.time = time;
        this.day = day;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Day: '" + day + '\'' +
                ",time: '" + time + '\'' ;
    }


}
