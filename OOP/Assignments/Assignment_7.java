/*
Design and develop a context for given case study and implement an interface for Vehicles. 
Consider the example of vehicles like bicycle, car and bike. 
All Vehicles have common functionalities such as Gear Change, Speed up and apply brakes. 
Make an interface and put all these functionalities. 
Bicycle, Bike, Car classes should be implemented for all these functionalities in their own class in their own way.
*/

interface Vehicle {
    void changeGear(int newGear);
    void speedUp(int increment);
    void applyBrakes(int decrement);
}

class Bicycle implements Vehicle {
    int speed = 0;
    int gear = 1;
    
    public void changeGear(int newGear) {
        gear = newGear;
        System.out.println("Bicycle gear changed to: " + gear);
    }

    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Bicycle speed increased to: " + speed);
    }

    public void applyBrakes(int decrement) {
        speed -= decrement;
        System.out.println("Bicycle speed decreased to: " + speed);
    }
}

class Bike implements Vehicle {
    int speed = 0;
    int gear = 1;

    public void changeGear(int newGear) {
        gear = newGear;
        System.out.println("Bike gear changed to: " +gear);
    }

    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Bike speed increased to: " + speed);
    }

    public void applyBrakes(int decrement) {
        speed -= decrement;
        System.out.println("Bike speed decreased to: " + speed);
    }
}

class Car implements Vehicle {
    int speed = 0;
    int gear = 1;

    public void changeGear(int newGear) {
        gear = newGear;
        System.out.println("Car gear changed to: "+gear);
    }

    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Car speed increased to: " + speed);
    }

    public void applyBrakes(int decrement) {
        speed += decrement;
        System.out.println("Car speed decreased to: " + speed);
    }
}

public class Assignment_7 {
    public static void main(String args[]) {
        Vehicle bicycle = new Bicycle();
        Vehicle bike = new Bike();
        Vehicle car = new Car();

        bicycle.changeGear(2);
        bicycle.speedUp(10);
        bicycle.applyBrakes(3);

        bike.changeGear(2);
        bike.speedUp(20);
        bike.applyBrakes(10);

        car.changeGear(2);
        car.speedUp(35);
        car.applyBrakes(15);
    }
}