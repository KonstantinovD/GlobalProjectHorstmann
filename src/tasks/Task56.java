package tasks;

import java.util.EnumMap;
import java.util.EnumSet;

public class Task56 implements TasksMainMethod {

    enum Weekday{
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY,}

    @Override
    public void run() {
        //EnumSet<Weekday> work = EnumSet.range(Weekday.SUNDAY, Weekday.FRIDAY); - that will be IllegalArgumentException: SUNDAY > FRIDAY
        EnumSet<Weekday> work = EnumSet.range(Weekday.MONDAY, Weekday.FRIDAY);



        System.out.println(work.contains(Weekday.SATURDAY));
        System.out.println(work.contains(Weekday.THURSDAY));

        work.add(Weekday.SATURDAY);

        EnumMap<Weekday, String> timetable = new EnumMap<Weekday, String>(Weekday.class);
    }
}
