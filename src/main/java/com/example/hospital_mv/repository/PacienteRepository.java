package com.example.hospital_mv.repository;

import com.example.hospital_mv.model.Paciente;


import org.springframework.data.jpa.repository.JpaRepository;


public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}
