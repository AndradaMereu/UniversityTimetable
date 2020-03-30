package utils;

import java.time.DayOfWeek;

public class Utils {
    public static int combineInts(int i1, int i2)
    {
        String sid = Integer.toString(i1) + Integer.toString(i2);
        return Integer.parseInt(sid);
    }

    public static DayOfWeek parseDayOfWeek(String weekday) throws Exception {
       if(weekday.equals("Monday")|| weekday.equals("mon"))
       {
           return DayOfWeek.MONDAY;
       }
       else if(weekday.equals("Tuesday")|| weekday.equals("tue"))
       {
           return DayOfWeek.TUESDAY;
       }
       else if(weekday.equals("Wednesday")|| weekday.equals("wed"))
       {
           return DayOfWeek.WEDNESDAY;
       }
       else if(weekday.equals("Thursay")|| weekday.equals("thu"))
       {
           return DayOfWeek.THURSDAY;
       }
       else if(weekday.equals("Friday")|| weekday.equals("fri"))
       {
           return DayOfWeek.FRIDAY;
       }
       else if (weekday.equals("Saturday")|| weekday.equals("sat"))
       {
           return DayOfWeek.MONDAY;
       }
       else if (weekday.equals("Sunday")|| weekday.equals("sun"))
       {
           return DayOfWeek.SUNDAY;
       }
       throw new Exception("Enter a valid day of the week");
    }


}
