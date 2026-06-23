# Traffic Light

```java
public interface TrafficLightState {
    void next(TrafficLight light);
    String getColor();
}
```


```java
public class TrafficLight {

    private TrafficLightState state;

    public TrafficLight(TrafficLightState initialState) {
        this.state = initialState;
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
```

## Requirements
States
```java
RED -> GREEN
GREEN -> YELLOW
YELLOW -> RED
```

## Usages
```java
TrafficLight light = new TrafficLight(new RedState());

System.out.println(light.currentColor());

light.next();
System.out.println(light.currentColor());

light.next();
System.out.println(light.currentColor());
```

## Expected 
```java
RED
GREEN
YELLOW
```