package org.miswah;

public class GreenState implements TrafficLightState{
    @Override
    public void next(TrafficLight light) {
        light.setState(light.getYellow());
    }

    @Override
    public String getColor() {
        return "GREEN";
    }
}
