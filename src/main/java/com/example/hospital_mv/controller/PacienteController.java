package com.example.hospital_mv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital_mv.model.Paciente;
import com.example.hospital_mv.service.PacienteService;

import java.util.List;



@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> listar(){
        List<Paciente> pacientes = pacienteService.findAll();
        if(pacientes.isEmpty()){
            return ResponseEntity.noContent().build(); // alternativa 2 -> return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(pacientes); //alternativa 2 -> return new ResponseEntity<>(pacientes, HyypStatus.OK);
    }

    @PostMapping 
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente){
        Paciente productoNuevo = pacienteService.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
        // return new ResponseEntity<>(productoNuevo, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Integer id){
        try {
           Paciente paciente = pacienteService.findById(id);
            return ResponseEntity.ok(paciente);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Integer id, @RequestBody Paciente paciente){
        try {
            Paciente pac = pacienteService.findById(id);
            
            pac.setId(id);
            pac.setRun(paciente.getRun());
            pac.setNombres(paciente.getNombres());
            pac.setApellidos(paciente.getApellidos());
            pac.setFechaNacimiento(paciente.getFechaNacimiento());
            pac.setCorreo(paciente.getCorreo());

            pacienteService.save(pac);
            return ResponseEntity.ok(paciente);
            
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try {
            pacienteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
    
