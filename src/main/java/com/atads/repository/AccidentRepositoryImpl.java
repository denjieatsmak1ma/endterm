package com.atads.repository;

import com.atads.model.AccidentEvent;
import com.atads.model.SensorData;
import com.atads.patterns.AccidentFactory;
import com.atads.repository.interfaces.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class AccidentRepositoryImpl implements CrudRepository<AccidentEvent> {

    private final JdbcTemplate jdbc;

    public AccidentRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public AccidentEvent create(AccidentEvent a) {
        Integer newId = jdbc.queryForObject(
                "INSERT INTO accident_events(type, location, latitude, longitude, severity) VALUES (?,?,?,?,?) RETURNING id",
                Integer.class,
                a.getAccidentType(),
                a.getLocation(),
                a.getLatitude(),
                a.getLongitude(),
                a.getSeverity()
        );

        SensorData s = a.getSensorData();
        jdbc.update(
                "INSERT INTO sensor_data(accident_id, speed, acceleration, timestamp) VALUES (?,?,?,?)",
                newId,
                s.getSpeed(),
                s.getAcceleration(),
                Timestamp.valueOf(s.getTimestamp())
        );

        return findById(newId);
    }

    @Override
    public List<AccidentEvent> findAll() {
        String sql = """
            SELECT a.id, a.type, a.location, a.latitude, a.longitude, a.severity,
                   s.speed, s.acceleration, s.timestamp
            FROM accident_events a
            JOIN sensor_data s ON s.accident_id = a.id
            ORDER BY a.id
            """;

        return jdbc.query(sql, (rs, rowNum) -> {
            SensorData sensor = new SensorData(
                    rs.getDouble("speed"),
                    rs.getDouble("acceleration"),
                    rs.getTimestamp("timestamp").toLocalDateTime()
            );

            return AccidentFactory.create(
                    rs.getString("type"),
                    rs.getInt("id"),
                    rs.getString("location"),
                    rs.getDouble("latitude"),
                    rs.getDouble("longitude"),
                    rs.getInt("severity"),
                    sensor
            );
        });
    }

    @Override
    public AccidentEvent findById(int id) {
        String sql = """
            SELECT a.id, a.type, a.location, a.latitude, a.longitude, a.severity,
                   s.speed, s.acceleration, s.timestamp
            FROM accident_events a
            JOIN sensor_data s ON s.accident_id = a.id
            WHERE a.id = ?
            """;

        return jdbc.queryForObject(sql, (rs, rowNum) -> {
            SensorData sensor = new SensorData(
                    rs.getDouble("speed"),
                    rs.getDouble("acceleration"),
                    rs.getTimestamp("timestamp").toLocalDateTime()
            );

            return AccidentFactory.create(
                    rs.getString("type"),
                    rs.getInt("id"),
                    rs.getString("location"),
                    rs.getDouble("latitude"),
                    rs.getDouble("longitude"),
                    rs.getInt("severity"),
                    sensor
            );
        }, id);
    }

    @Override
    public AccidentEvent update(int id, AccidentEvent a) {
        jdbc.update(
                "UPDATE accident_events SET type=?, location=?, latitude=?, longitude=?, severity=? WHERE id=?",
                a.getAccidentType(),
                a.getLocation(),
                a.getLatitude(),
                a.getLongitude(),
                a.getSeverity(),
                id
        );

        SensorData s = a.getSensorData();
        jdbc.update(
                "UPDATE sensor_data SET speed=?, acceleration=?, timestamp=? WHERE accident_id=?",
                s.getSpeed(),
                s.getAcceleration(),
                Timestamp.valueOf(s.getTimestamp()),
                id
        );

        return findById(id);
    }

    @Override
    public void delete(int id) {
        jdbc.update("DELETE FROM accident_events WHERE id=?", id);
    }
}
