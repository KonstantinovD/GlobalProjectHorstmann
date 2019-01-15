package tasks.task45;

public class Car{
    private String brand;
    private int maxSpeed;
    private int seats;

    private final static int defaultMaxSpeed = 120;
    private final static int defaultSeats = 5;

    public Car(){
        brand = "";
        maxSpeed = defaultMaxSpeed;
        seats = defaultSeats;
    }

    public Car(int maxSpeed, int seats){
        this.seats = seats;
        this.maxSpeed = maxSpeed;
        brand = "";
    }

    public Car(int maxSpeed, int seats, String brand){
        this.seats = seats;
        this.maxSpeed = maxSpeed;
        this.brand = brand;
    }

    //getters
    public int getMaxSpeed() {
        return maxSpeed;
    }
    public int getSeats() {
        return seats;
    }
    public String getBrand() {
        return brand;
    }

    //setters
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    public void setSeats(int seats) {
        this.seats = seats;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
}