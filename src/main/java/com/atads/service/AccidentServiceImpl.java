package com.atads.service;

import com.atads.dto.AccidentDTO;
import com.atads.model.AccidentEvent;
import com.atads.model.SensorData;
import com.atads.patterns.AccidentFactory;
import com.atads.patterns.SensorDataBuilder;
import com.atads.repository.interfaces.CrudRepository;
import com.atads.service.interfaces.AccidentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class AccidentServiceImpl implements AccidentService {

    private final CrudRepository<AccidentEvent> repo;

    public AccidentServiceImpl(CrudRepository<AccidentEvent> repo) {
        this.repo = repo;
    }

    private AccidentDTO toDto(AccidentEvent a) {
        AccidentDTO d = new AccidentDTO();
        d.id = a.getId();
        d.type = a.getAccidentType();
        d.location = a.getLocation();
        d.latitude = a.getLatitude();
        d.longitude = a.getLongitude();
        d.severity = a.getSeverity();

        d.speed = a.getSensorData().getSpeed();
        d.acceleration = a.getSensorData().getAcceleration();
        d.timestamp = a.getSensorData().getTimestamp().toString();
        return d;
    }

    private LocalDateTime parseTimestampOrNow(String ts) {
        if (ts == null || ts.isBlank()) return LocalDateTime.now();
        try {
            return LocalDateTime.parse(ts);
        } catch (DateTimeParseException e) {
            return LocalDateTime.now();
        }
    }

    private AccidentEvent fromDto(AccidentDTO dto) {
        SensorData sensor = new SensorDataBuilder()
                .speed(dto.speed)
                .acceleration(dto.acceleration)
                .timestamp(parseTimestampOrNow(dto.timestamp))
                .build();

        return AccidentFactory.create(
                dto.type,
                dto.id,
                dto.location,
                dto.latitude,
                dto.longitude,
                dto.severity,
                sensor
        );
    }

    @Override
    public AccidentDTO create(AccidentDTO dto) {
        return toDto(repo.create(fromDto(dto)));
    }

    @Override
    public List<AccidentDTO> getAll() {
        return repo.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public AccidentDTO getById(int id) {
        return toDto(repo.findById(id));
    }

    @Override
    public AccidentDTO update(int id, AccidentDTO dto) {
        return toDto(repo.update(id, fromDto(dto)));
    }

    @Override
    public void delete(int id) {
        repo.delete(id);
    }
}
