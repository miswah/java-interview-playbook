package org.miswah;

public class RedState implements TrafficLightState{

    @Override
    public void next(TrafficLight light) {
        light.setState(light.getGreen());
    }

    @Override
    public String getColor() {
        return "RED";
    }
}
