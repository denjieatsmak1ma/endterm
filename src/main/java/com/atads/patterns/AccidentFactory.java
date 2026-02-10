package com.atads.patterns;

import com.atads.model.*;

public final class AccidentFactory {

    private AccidentFactory() {}

    public static AccidentEvent create(String type,
                                       int id,
                                       String location,
                                       double latitude,
                                       double longitude,
                                       int severity,
                                       SensorData sensorData) {

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("type is required");
        }

        String t = type.trim().toUpperCase();

        if (t.equals("VEHICLE") || t.equals("VEHICLE_COLLISION")) {
            return new VehicleCollision(id, location, latitude, longitude, severity, sensorData);
        }

        if (t.equals("PEDESTRIAN") || t.equals("PEDESTRIAN_ACCIDENT")) {
            return new PedestrianAccident(id, location, latitude, longitude, severity, sensorData);
        }

        throw new IllegalArgumentException("Unknown accident type: " + type);
    }
}
