package com.clinica.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "clinicas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identificador;

    private String nombre;

    private String direccion;

    @Column(name = "cantidad_camas")
    private Integer cantidadCamas;

    private String telefono;

    private String correo;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL)
    private List<Doctor> doctores;
}
