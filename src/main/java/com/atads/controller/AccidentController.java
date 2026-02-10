package com.atads.controller;

import com.atads.dto.AccidentDTO;
import com.atads.service.interfaces.AccidentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accidents")
public class AccidentController {

    private final AccidentService service;

    public AccidentController(AccidentService service) {
        this.service = service;
    }

    @GetMapping
    public List<AccidentDTO> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AccidentDTO one(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccidentDTO create(@RequestBody AccidentDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public AccidentDTO update(@PathVariable int id, @RequestBody AccidentDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
