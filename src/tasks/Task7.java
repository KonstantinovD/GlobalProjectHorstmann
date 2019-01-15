package tasks;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

public class Task7 implements TasksMainMethod{
    @Override
    public void run() {


        by.konstantinov.calendar.ConsoleCalendar csCal = new  by.konstantinov.calendar.ConsoleCalendar();
        csCal.print();

        System.out.println();

        LocalDate dateBefore = LocalDate.now();
        dateBefore = dateBefore.minusMonths(1);
        csCal.setDate(dateBefore);
        csCal.print();

        LocalDate myBirthday = LocalDate.of(1998, 12, 26);

        csCal.setDate(myBirthday);
        csCal.print();
    }
}

class ConsoleCalendar{
    private LocalDate date;

    ConsoleCalendar(){
        this.date = LocalDate.now();
    }
    ConsoleCalendar(LocalDate date){
        this.setDate(date);
    }

    void setDate(LocalDate date){
        this.date = date;
    }
    void print(){
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today-1);
        int weekdayValue = date.getDayOfWeek().getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for(int i=1; i<weekdayValue; i++){
            System.out.print("    ");
        }
        while(date.getMonthValue() == month){
            System.out.printf("%3d", date.getDayOfMonth());
            if(date.getDayOfMonth() == today)
                System.out.print("*");
            else
                System.out.print(" ");
            date = date.plusDays(1);
            if(date.getDayOfWeek().getValue() == 1)
                System.out.println();
        }
        if(date.getDayOfWeek().getValue() != 1 )
            System.out.println();
    }
}
