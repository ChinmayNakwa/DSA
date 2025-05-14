/*
Design and develop a context for given case study and implement an interface for Vehicles. Consider the example of vehicles like bicycle, car and bike. 
All Vehicles have common functionalities such as Gear Change, Speed up and apply brakes. 
Make an interface and put all these functionalities. 
Bicycle, Bike, Car classes should be implemented for all these functionalities in their own class in their own way.  
*/

interface Vehicle {
    void changeGear(int newGear);
    void speedUp(int increment);
    void applyBrakes(int decrement);
    void displayStatus();
}

class Bicycle implements Vehicle {
    private int gear;
    private int speed;
    
    public Bicycle() {
        this.gear = 1;
        this.speed = 0;
    }
    
    @Override
    public void changeGear(int newGear) {
        if (newGear >= 1 && newGear <= 6) {
            this.gear = newGear;
            System.out.println("Bicycle gear changed to: " + this.gear);
        } else {
            System.out.println("Invalid gear for bicycle (1-6)");
        }
    }
    
    @Override
    public void speedUp(int increment) {
        this.speed += increment;
        System.out.println("Bicycle speed increased to: " + this.speed + " km/h");
    }
    
    @Override
    public void applyBrakes(int decrement) {
        this.speed = Math.max(0, this.speed - decrement);
        System.out.println("Bicycle speed decreased to: " + this.speed + " km/h");
    }
    
    @Override
    public void displayStatus() {
        System.out.println("Bicycle Status - Gear: " + gear + ", Speed: " + speed + " km/h");
    }
}

class Bike implements Vehicle {
    private int gear;
    private int speed;
    
    public Bike() {
        this.gear = 0; // Neutral
        this.speed = 0;
    }
    
    @Override
    public void changeGear(int newGear) {
        if (newGear >= 0 && newGear <= 5) {
            this.gear = newGear;
            System.out.println("Bike gear changed to: " + this.gear);
        } else {
            System.out.println("Invalid gear for bike (0-5)");
        }
    }
    
    @Override
    public void speedUp(int increment) {
        this.speed += increment;
        System.out.println("Bike speed increased to: " + this.speed + " km/h");
    }
    
    @Override
    public void applyBrakes(int decrement) {
        this.speed = Math.max(0, this.speed - decrement);
        System.out.println("Bike speed decreased to: " + this.speed + " km/h");
    }
    
    @Override
    public void displayStatus() {
        System.out.println("Bike Status - Gear: " + gear + ", Speed: " + speed + " km/h");
    }
}

class Car implements Vehicle {
    private int gear;
    private int speed;
    
    public Car() {
        this.gear = 0; // Park
        this.speed = 0;
    }
    
    @Override
    public void changeGear(int newGear) {
        if (newGear >= -1 && newGear <= 6) { // -1 for reverse
            this.gear = newGear;
            System.out.println("Car gear changed to: " + this.gear);
        } else {
            System.out.println("Invalid gear for car (-1 to 6)");
        }
    }
    
    @Override
    public void speedUp(int increment) {
        this.speed += increment;
        System.out.println("Car speed increased to: " + this.speed + " km/h");
    }
    
    @Override
    public void applyBrakes(int decrement) {
        this.speed = Math.max(0, this.speed - decrement);
        System.out.println("Car speed decreased to: " + this.speed + " km/h");
    }
    
    @Override
    public void displayStatus() {
        System.out.println("Car Status - Gear: " + gear + ", Speed: " + speed + " km/h");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle bicycle = new Bicycle();
        Vehicle bike = new Bike();
        Vehicle car = new Car();
        
        System.out.println("\n--- Testing Bicycle ---");
        bicycle.changeGear(2);
        bicycle.speedUp(15);
        bicycle.applyBrakes(5);
        bicycle.displayStatus();
        
        System.out.println("\n--- Testing Bike ---");
        bike.changeGear(3);
        bike.speedUp(40);
        bike.applyBrakes(10);
        bike.displayStatus();
        
        System.out.println("\n--- Testing Car ---");
        car.changeGear(1);
        car.speedUp(30);
        car.applyBrakes(15);
        car.displayStatus();
    }
}