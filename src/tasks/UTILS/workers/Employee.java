package tasks.UTILS.workers;

import java.time.LocalDate;

public class Employee implements Cloneable{
    private String name;
    private double salary;
    private LocalDate hireDay;


    public Employee(String name, double salary, int year, int month, int day){
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public Employee clone() throws  CloneNotSupportedException
    {
        //Object.clone() call
        Employee cloned = (Employee) super.clone();
        //clone objects
        cloned.hireDay = hireDay;

        return cloned;
    }


    /**
     * Sets specified date of recruiting
     * @param year
     * @param month
     * @param day
     */
    public void setHireDay(int year, int month, int day){
        hireDay = LocalDate.of(year, month, day);

    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString(){
        return "Employee[name=" + name + ", salaty=" + salary +
                ", hireDay=" + hireDay + "]";
    }


    //getters

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public String getName() {
        return name;
    }
}
