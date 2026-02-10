package com.atads.patterns;

import com.atads.model.SensorData;

import java.time.LocalDateTime;

public class SensorDataBuilder {

    private double speed;
    private double acceleration;
    private LocalDateTime timestamp = LocalDateTime.now();

    public SensorDataBuilder speed(double speed) {
        this.speed = speed;
        return this;
    }

    public SensorDataBuilder acceleration(double acceleration) {
        this.acceleration = acceleration;
        return this;
    }

    public SensorDataBuilder timestamp(LocalDateTime timestamp) {
        if (timestamp != null) this.timestamp = timestamp;
        return this;
    }

    public SensorData build() {
        return new SensorData(speed, acceleration, timestamp);
    }
}
