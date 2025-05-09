package com.example.hospital_mv.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "paciente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(unique = true, length = 13, nullable = false)
    private String run;
    
    @Column(nullable = false)
    private String nombres;
    
    @Column(nullable = false)
    private String apellidos;
    
    @Column(nullable = true)
    private Date fechaNacimiento;
    
    @Column(nullable = false)
    private String correo;

    
    @OneToMany(mappedBy = "paciente")
    private List<Atencion> atenciones;

}
