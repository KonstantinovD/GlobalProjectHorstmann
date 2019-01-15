package tasks.UTILS.workers;

public class Manager extends Employee {

    private double bonus;

    public Manager(String name, double salary, int year, int month, int day){
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public void setBonus(double bonus) {
        if(bonus >= 0.0) {
            this.bonus = bonus;
        }
    }

    public double getBonus() {
        return bonus;
    }

    public double getSalary(){
        return (super.getSalary() + bonus);
    }
}
