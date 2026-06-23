package org.miswah;

public class YellowState implements TrafficLightState{
    @Override
    public void next(TrafficLight light) {
        light.setState(light.getRed());
    }

    @Override
    public String getColor() {
        return "YELLOW";
    }
}
