package tasks;

import tasks.task45.Car;

import java.lang.reflect.Constructor;

public class Task45 implements TasksMainMethod{
    @Override
    public void run() {
        Car car;
        try
        {
            //Class cl = Class.forName("Car");

            car = Car.class.getConstructor().newInstance();
            System.out.println("max speed: " + car.getMaxSpeed() + ", number of seats: "
                    + car.getSeats() + ", brand: " + car.getBrand());

            Class cls[] = new Class[] { int.class, int.class, String.class};

            //Constructor cstr = Car.class.getConstructor(cls);
            //System.out.println(cls);

            car = Car.class.getConstructor(cls).newInstance(135, 4, "Volvo");

            System.out.println("max speed: " + car.getMaxSpeed() + ", number of seats: "
                    + car.getSeats() + ", brand: " + car.getBrand());


        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


}


