package org.miswah;

public interface TrafficLightState {
    void next(TrafficLight light);
    String getColor();
}
