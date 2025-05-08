package com.example.hospital_mv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "atencion")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Atencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String fechaAtencion;

    @Column(nullable = false)
    private String horaAtencion;

    @Column(nullable = false)
    private double costo;

    
    @ManyToOne
    @JoinColumn(name = "atencion_id", nullable = false)
    private Paciente paciente;

    
}
