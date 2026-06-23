package org.miswah;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        TrafficLight light = new TrafficLight(new RedState());

        System.out.println(light.currentColor());

        light.next();
        System.out.println(light.currentColor());

        light.next();
        System.out.println(light.currentColor());
    }
}

