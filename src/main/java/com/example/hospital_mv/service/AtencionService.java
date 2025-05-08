package com.example.hospital_mv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital_mv.model.Atencion;
import com.example.hospital_mv.repository.AtencionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AtencionService {

    @Autowired
    private AtencionRepository atencionRepository;

    public List<Atencion> findAll(){
        return atencionRepository.findAll();
    }

    public Atencion findById(int id){
        return atencionRepository.findById(id).get();
    }

    public Atencion save(Atencion atencion){
        return atencionRepository.save(atencion);
    }

    public void delete(int id){
        atencionRepository.deleteById(id);
    }

}
