package com.clinica.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "doctores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String especialidad;

    @ManyToOne
    @JoinColumn(name = "clinica_id")
    private Clinica clinica;

    private String telefono;

    private String correo;

    @Column(name = "fecha_contratacion")
    private LocalDate fechaContratacion;
}
