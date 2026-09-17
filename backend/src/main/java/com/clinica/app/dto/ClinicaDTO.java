package com.clinica.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClinicaDTO {

    private Long identificador;
    private String nombre;
    private String direccion;
    private Integer cantidadCamas;
    private String telefono;
    private String correo;
    private LocalDate fechaCreacion;
}
