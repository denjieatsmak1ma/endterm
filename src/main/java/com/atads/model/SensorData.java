package com.atads.model;

import java.time.LocalDateTime;

public class SensorData {
    private final double speed;
    private final double acceleration;
    private final LocalDateTime timestamp;

    public SensorData(double speed, double acceleration, LocalDateTime timestamp) {
        this.speed = speed;
        this.acceleration = acceleration;
        this.timestamp = timestamp;
    }

    public double getSpeed() { return speed; }
    public double getAcceleration() { return acceleration; }
    public LocalDateTime getTimestamp() { return timestamp; }
}
