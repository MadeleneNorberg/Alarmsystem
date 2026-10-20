package Sensors;

public class SmokeSensor extends Sensor {

    public SmokeSensor(String ID, String location) {
        super(ID, location);
        this.active=true;
    }


    @Override
    public void trigger() {
        triggered = true;
        System.out.println("Smoke detected at " + getLabel());
    }

    @Override
    public void disarm() {

        System.out.println(getLabel() + " cannot be disarmed (always active).");
    }
}
