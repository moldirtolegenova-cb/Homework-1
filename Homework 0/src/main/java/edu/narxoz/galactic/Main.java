package main.java.edu.narxoz.galactic;
import main.java.edu.narxoz.galactic.bodies.*;
import main.java.edu.narxoz.galactic.cargo.*;
import main.java.edu.narxoz.galactic.drones.*;
import main.java.edu.narxoz.galactic.task.*;
import main.java.edu.narxoz.galactic.dispatcher.*;
public class Main {
    public static void main(String[] args) {
        Planet earth = new Planet("Earth", 0, 0, "Nitrogen-Oxygen");
        Planet mars = new Planet("Mars", 100, 100, "CO2");
        Cargo heavyCargo = new Cargo(60, "Heavy Machinery");
        LightDrone lightDrone = new LightDrone("LD-01", 50); 
        HeavyDrone heavyDrone = new HeavyDrone("HD-01", 200); 
        DeliveryTask task = new DeliveryTask(earth, mars, heavyCargo);
        Dispatcher dispatcher = new Dispatcher();
        System.out.println("--- Attempting Light Drone Assignment ---");
        Result res1 = dispatcher.assignTask(task, lightDrone);
        System.out.println("Result: " + res1.ok() + " Reason: " + res1.reason());
        System.out.println("\n--- Attempting Heavy Drone Assignment ---");
        Result res2 = dispatcher.assignTask(task, heavyDrone);
        System.out.println("Result: " + res2.ok());
        System.out.println("Drone Status: " + heavyDrone.getStatus()); 
        System.out.println("\nEstimated Time: " + task.estimateTime() + " mins");
        System.out.println("\n--- Completing Task ---");
        Result res3 = dispatcher.completeTask(task);
        System.out.println("Result: " + res3.ok());
        System.out.println("Final Task State: " + task.getState());
        System.out.println("Final Drone Status: " + heavyDrone.getStatus());
    }
}