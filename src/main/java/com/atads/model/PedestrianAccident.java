package com.atads.model;

public class PedestrianAccident extends AccidentEvent {

    public PedestrianAccident(int id,
                              String location,
                              double latitude,
                              double longitude,
                              int severity,
                              SensorData sensorData) {
        super(id, location, latitude, longitude, severity, sensorData);
    }

    @Override
    public String getAccidentType() {
        return "PEDESTRIAN";
    }

    @Override
    public void processAccident() {

    }
}
