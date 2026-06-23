package org.miswah;

public class TrafficLight {

    public TrafficLightState getRed() {
        return red;
    }

    public TrafficLightState getGreen() {
        return green;
    }

    public TrafficLightState getYellow() {
        return yellow;
    }

    private TrafficLightState red;
    private TrafficLightState green;
    private TrafficLightState yellow;

    private TrafficLightState state;

    public TrafficLight(TrafficLightState initialState) {
        this.state = initialState;
        this.red = new RedState();
        this.green = new GreenState();
        this.yellow = new YellowState();
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void next() {
        state.next(this);
    }

    public String currentColor() {
        return state.getColor();
    }
}
