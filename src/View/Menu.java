package View;

import Service.Alarmsystem;
import java.util.Scanner;

public class Menu {

    private final Alarmsystem system;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(Alarmsystem system) {
        this.system = system;
    }

    public void run() {
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Select: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                system.armAll();
            } else if (choice.equals("2")) {
                system.disarmAll();
            } else if (choice.equals("3")) {
                System.out.print("Enter sensor ID: ");
                String id = scanner.nextLine().trim();
                system.triggerSensor(id);
            } else if (choice.equals("4")) {
                system.printSensors();
            } else if (choice.equals("5")) {
                system.counter();
            } else if (choice.equals("6")) {
                system.resetAllSensors();
            } else if (choice.equals("7")) {
                if(system.isSystemTriggered()){
                    System.out.println(" System is trigged!");
                }else{
                    System.out.println("System is calm");
                }
            } else if (choice.equals("0")) {
                running = false;
                System.out.println("Program shutting down...");
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private void printMenu() {
        System.out.println("================================");
        System.out.println("          Alarm System");
        System.out.println("================================");
        System.out.println("1. Arm all sensors");
        System.out.println("2. Disarm all sensors");
        System.out.println("3. Trigger sensor by ID");
        System.out.println("4. Show all sensors");
        System.out.println("5. Count triggered sensors");
        System.out.println("6. Reset all sensors");
        System.out.println("7. Check if system is triggered");
        System.out.println("0. Exit");
    }
}
