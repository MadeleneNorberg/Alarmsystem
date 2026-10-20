package Service;

import Sensors.DoorSensor;
import Sensors.MotionSensor;
import Sensors.Sensor;
import Sensors.SmokeSensor;

import java.util.ArrayList;
import java.util.List;

public class Alarmsystem {

    private final List<Sensor> sensors = new ArrayList<>();

    public Alarmsystem (){
        sensors.add(new DoorSensor("D1", "Hallway"));
        sensors.add(new MotionSensor("M1", "Garage"));
        sensors.add(new SmokeSensor("S1", "Office"));
        sensors.add(new MotionSensor("M2", "Storage"));

    }

    public void addSensor(Sensor s) {
        sensors.add(s);
    }

    public void armAll() {
        for (Sensor s : sensors) s.arm();
    }

    public void disarmAll() {
        for (Sensor s : sensors) s.disarm();
    }

    public void resetAllSensors() {
        for (Sensor s : sensors) s.reset();
        System.out.println("All sensors reset.");
    }

    public void triggerSensor(String id) {
        for (Sensor s : sensors) {
            if (s.getId().equals(id)) {
                s.trigger();
                return;
            }
        }
        System.out.println("No sensor found with ID: " + id);
    }

    public boolean isSystemTriggered() {
        for (Sensor s : sensors) {
            if (s.isTriggered()) return true;
        }
        return false;
    }

    public void printSensors() {
        System.out.println("Sensor Status");
        for (Sensor s : sensors) {
            System.out.println(s.getLabel() + " | Active: " + s.isActive() + " | Triggered: " + s.isTriggered());
        }
    }

    public void counter() {
        int count = 0;
        for (Sensor s : sensors) {
            if (s.isTriggered()) count++;
        }
        System.out.println("Triggered sensors: " + count);
    }



}



