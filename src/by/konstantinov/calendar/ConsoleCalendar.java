package by.konstantinov.calendar;

import by.konstantinov.testdoc.TestDoc;

import java.time.LocalDate;

/**
 * Object of {@code ConsoleCalendar} represents
 * an ordinary calendar which is printed in the console
 * (using {@code System.out})
 * @author Daniil Konstantinov
 */
public class ConsoleCalendar {
    private LocalDate date;
    private int month;
    private int today;

    /**
     * Creates calendar and sets current date
     */
    public ConsoleCalendar(){
        this.date = LocalDate.now();
        prepareMonthForPrinting();
    }

    /**
     * Creates calendar and sets specified date
     * @param date - date to be set to calendar
     */
    public ConsoleCalendar(LocalDate date){
        this.setDate(date);
        prepareMonthForPrinting();
    }

    /**
     * Calculated current month and sets date
     * to the beginning of it
     */
    private void prepareMonthForPrinting(){
        month = date.getMonthValue();
        today = date.getDayOfMonth();
        date = date.minusDays(today-1);
    }

    /**
     * Sets date to calendar
     * @param date - date to be set to calendar
     * @see TestDoc#docMethod()
     */
    public void setDate(LocalDate date){
        this.date = date;
        prepareMonthForPrinting();
    }

    /**
     * Returns current calendar date
     * @return Returns LocalDate as a result
     * @see <a href="https://docs.oracle.com/javase/10/docs/api/java/time/LocalDate.html">java.time.LocalDate</a>
     */
    public LocalDate getDate(){
        return this.date;
    }

    /**
     * Prints current month in the console
     */
    public void print(){
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
