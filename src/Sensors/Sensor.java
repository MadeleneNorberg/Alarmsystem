package Sensors;

import Service.Methods;

public abstract class Sensor implements Methods {

    protected String id;
    protected String location;
    protected boolean active;
    protected boolean triggered;

    public Sensor(String id, String location) {
        this.id = id;
        this.location = location;
        this.active = false;
        this.triggered = false;
    }

    public String getId() {
        return id;
    }


    public boolean isActive() {
        return active;
    }

    public boolean isTriggered() {
        return triggered;
    }

    public String getLabel() {

        return id + " (" + location + ")";
    }

    @Override
    public void arm() {
        active = true;
        System.out.println(getLabel() + " is armed.");
    }

    @Override
    public void disarm() {
        active = false;
        triggered = false;
        System.out.println(getLabel() + " is disarmed.");
    }

    @Override
    public void trigger() {
        if (active) {
            triggered = true;
            System.out.println(getLabel() + " is triggered!");
        }
    }

    @Override
    public void reset() {

        triggered = false;
    }
}

