package com.example.hospital_mv.service;

import com.example.hospital_mv.model.Paciente;
import com.example.hospital_mv.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> getPatientById(int id){
        return pacienteRepository.findById(id);
    }
}
