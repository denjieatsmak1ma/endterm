package com.atads.model;

public abstract class AccidentEvent {
    protected int id;
    protected String location;
    protected double latitude;
    protected double longitude;
    protected int severity;
    protected SensorData sensorData;

    public AccidentEvent(int id, String location, double latitude, double longitude, int severity, SensorData sensorData) {
        this.id = id;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.severity = severity;
        this.sensorData = sensorData;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLocation() { return location; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public int getSeverity() { return severity; }
    public SensorData getSensorData() { return sensorData; }

    public abstract String getAccidentType();
    public abstract void processAccident();
}
