DROP TABLE IF EXISTS sensor_data;
DROP TABLE IF EXISTS accident_events;

CREATE TABLE accident_events(
id SERIAL PRIMARY KEY,
type VARCHAR(50) NOT NULL,
location VARCHAR(255) NOT NULL,
latitude DOUBLE PRECISION NOT NULL,
longitude DOUBLE PRECISION NOT NULL,
severity INTEGER NOT NULL CHECK (severity BETWEEN 1 AND 10),UNIQUE (latitude, longitude)
);

CREATE TABLE sensor_data(
id SERIAL PRIMARY KEY,
accident_id INTEGER NOT NULL UNIQUE,
speed DOUBLE PRECISION NOT NULL,
acceleration DOUBLE PRECISION NOT NULL,
timestamp TIMESTAMP NOT NULL,
CONSTRAINT fk_accident
FOREIGN KEY (accident_id) REFERENCES accident_events(id)
ON DELETE CASCADE
);

WITH a1 AS (
INSERT INTO accident_events (type, location, latitude, longitude, severity)
VALUES ('VEHICLE_COLLISION', 'Main Street', 51.1001, 71.4001, 5)
    RETURNING id
    )
INSERT INTO sensor_data (accident_id, speed, acceleration, timestamp)
SELECT id, 60.5, 2.3, '2026-01-22 10:30:00' FROM a1;

WITH a2 AS (
INSERT INTO accident_events (type, location, latitude, longitude, severity)
VALUES ('PEDESTRIAN_ACCIDENT', 'Central Ave', 51.2002, 71.5002, 4)
    RETURNING id
    )
INSERT INTO sensor_data (accident_id, speed, acceleration, timestamp)
SELECT id, 28.0, 1.1, '2026-01-22 11:05:00' FROM a2;

WITH a3 AS (
INSERT INTO accident_events (type, location, latitude, longitude, severity)
VALUES ('VEHICLE_COLLISION', 'Abay Road', 51.3003, 71.6003, 8)
    RETURNING id
    )
INSERT INTO sensor_data (accident_id, speed, acceleration, timestamp)
SELECT id, 92.3, 3.7, '2026-01-22 12:40:00' FROM a3;

WITH a4 AS (
INSERT INTO accident_events (type, location, latitude, longitude, severity)
VALUES ('PEDESTRIAN_ACCIDENT', 'Republic Avenue', 51.4004, 71.7004, 3)
    RETURNING id
    )
INSERT INTO sensor_data (accident_id, speed, acceleration, timestamp)
SELECT id, 22.5, 0.8, '2026-01-22 13:15:00' FROM a4;

WITH a5 AS (
INSERT INTO accident_events (type, location, latitude, longitude, severity)
VALUES ('VEHICLE_COLLISION', 'Saryarka Street', 51.5005, 71.8005, 6)
    RETURNING id
    )
INSERT INTO sensor_data (accident_id, speed, acceleration, timestamp)
SELECT id, 75.0, 2.9, '2026-01-22 14:00:00' FROM a5;

WITH a6 AS (
INSERT INTO accident_events (type, location, latitude, longitude, severity)
VALUES ('PEDESTRIAN_ACCIDENT', 'Tauelsizdik Avenue', 51.6006, 71.9006, 2)
    RETURNING id
    )
INSERT INTO sensor_data (accident_id, speed, acceleration, timestamp)
SELECT id, 18.0, 0.6, '2026-01-22 15:10:00' FROM a6;

WITH a7 AS (
INSERT INTO accident_events (type, location, latitude, longitude, severity)
VALUES ('VEHICLE_COLLISION', 'Kabanbay Batyr Ave', 51.7007, 72.0007, 7)
    RETURNING id
    )
INSERT INTO sensor_data (accident_id, speed, acceleration, timestamp)
SELECT id, 85.2, 3.1, '2026-01-22 16:20:00' FROM a7;

WITH a8 AS (
INSERT INTO accident_events (type, location, latitude, longitude, severity)
VALUES ('PEDESTRIAN_ACCIDENT', 'Zheltoksan Street', 51.8008, 72.1008, 5)
    RETURNING id
    )
INSERT INTO sensor_data (accident_id, speed, acceleration, timestamp)
SELECT id, 32.0, 1.4, '2026-01-22 17:05:00' FROM a8;

WITH a9 AS (
INSERT INTO accident_events (type, location, latitude, longitude, severity)
VALUES ('VEHICLE_COLLISION', 'Turan Avenue', 51.9009, 72.2009, 9)
    RETURNING id
    )
INSERT INTO sensor_data (accident_id, speed, acceleration, timestamp)
SELECT id, 110.5, 4.2, '2026-01-22 18:45:00' FROM a9;

WITH a10 AS (
INSERT INTO accident_events (type, location, latitude, longitude, severity)
VALUES ('PEDESTRIAN_ACCIDENT', 'Seifullin Street', 52.0010, 72.3010, 1)
    RETURNING id
    )
INSERT INTO sensor_data (accident_id, speed, acceleration, timestamp)
SELECT id, 12.0, 0.4, '2026-01-22 19:30:00' FROM a10;
