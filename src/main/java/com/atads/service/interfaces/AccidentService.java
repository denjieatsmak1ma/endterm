package com.atads.service.interfaces;

import com.atads.dto.AccidentDTO;

import java.util.List;

public interface AccidentService {
    AccidentDTO create(AccidentDTO dto);
    List<AccidentDTO> getAll();
    AccidentDTO getById(int id);
    AccidentDTO update(int id, AccidentDTO dto);
    void delete(int id);
}
