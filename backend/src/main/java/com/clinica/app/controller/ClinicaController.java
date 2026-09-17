package com.clinica.app.controller;

import com.clinica.app.dto.ClinicaDTO;
import com.clinica.app.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinicas")
@CrossOrigin(origins = "http://localhost:4200")
public class ClinicaController {

    @Autowired
    private ClinicaService clinicaService;

    @GetMapping
    public ResponseEntity<List<ClinicaDTO>> obtenerTodas() {
        return ResponseEntity.ok(clinicaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicaDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clinicaService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<ClinicaDTO> crear(@RequestBody ClinicaDTO clinicaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clinicaService.crear(clinicaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicaDTO> actualizar(@PathVariable Long id, @RequestBody ClinicaDTO clinicaDTO) {
        return ResponseEntity.ok(clinicaService.actualizar(id, clinicaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clinicaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
