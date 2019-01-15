package tasks;

//Horstmann part 1 page 286
// CLONE

import java.util.Date;
import java.util.GregorianCalendar;

public class Task21 implements TasksMainMethod {
    @Override
    public void run() {
        try{
            Employee original = new Employee("John Q. Public", 50000);
            original.setHireDay(200, 1, 1);
            Employee copy = original.clone();
            copy.raiseSalary(10);

            copy.setHireDay(2002, 12, 31);

            System.out.println("original - " + original);
            System.out.println("copy - " + copy);

        }catch (CloneNotSupportedException ex){
            ex.printStackTrace();
        }
    }
}

class Employee implements Cloneable{
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
        hireDay = new Date();
    }

    public Employee clone() throws  CloneNotSupportedException
    {
        //Object.clone() call
        Employee cloned = (Employee) super.clone();
        //clone objects
        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }


    /**
     * Sets specified date of recruiting
     * @param year
     * @param month
     * @param day
     */
    public void setHireDay(int year, int month, int day){
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();

        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString(){
        return "Employee[name=" + name + ", salaty=" + salary +
                ", hireDay=" + hireDay + "]";
    }
}











