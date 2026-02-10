package com.atads.model;

public class VehicleCollision extends AccidentEvent {

    public VehicleCollision(int id,
                            String location,
                            double latitude,
                            double longitude,
                            int severity,
                            SensorData sensorData) {
        super(id, location, latitude, longitude, severity, sensorData);
    }

    @Override
    public String getAccidentType() {
        return "VEHICLE";
    }

    @Override
    public void processAccident() {

    }
}
