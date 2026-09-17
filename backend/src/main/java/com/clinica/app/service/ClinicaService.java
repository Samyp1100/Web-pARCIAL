package com.clinica.app.service;

import com.clinica.app.dto.ClinicaDTO;
import com.clinica.app.model.Clinica;
import com.clinica.app.repository.ClinicaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClinicaService {

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ClinicaDTO> obtenerTodas() {
        return clinicaRepository.findAll()
                .stream()
                .map(clinica -> modelMapper.map(clinica, ClinicaDTO.class))
                .collect(Collectors.toList());
    }

    public ClinicaDTO obtenerPorId(Long id) {
        Clinica clinica = clinicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clínica no encontrada"));
        return modelMapper.map(clinica, ClinicaDTO.class);
    }

    public ClinicaDTO crear(ClinicaDTO clinicaDTO) {
        Clinica clinica = modelMapper.map(clinicaDTO, Clinica.class);
        Clinica clinicaGuardada = clinicaRepository.save(clinica);
        return modelMapper.map(clinicaGuardada, ClinicaDTO.class);
    }

    public ClinicaDTO actualizar(Long id, ClinicaDTO clinicaDTO) {
        Clinica clinica = clinicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clínica no encontrada"));

        clinica.setNombre(clinicaDTO.getNombre());
        clinica.setDireccion(clinicaDTO.getDireccion());
        clinica.setCantidadCamas(clinicaDTO.getCantidadCamas());
        clinica.setTelefono(clinicaDTO.getTelefono());
        clinica.setCorreo(clinicaDTO.getCorreo());
        clinica.setFechaCreacion(clinicaDTO.getFechaCreacion());

        Clinica clinicaActualizada = clinicaRepository.save(clinica);
        return modelMapper.map(clinicaActualizada, ClinicaDTO.class);
    }

    public void eliminar(Long id) {
        clinicaRepository.deleteById(id);
    }
}
