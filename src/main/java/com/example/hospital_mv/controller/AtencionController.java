package com.example.hospital_mv.controller;

import java.util.List;

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

import com.example.hospital_mv.model.Atencion;
import com.example.hospital_mv.service.AtencionService;

@RestController
@RequestMapping("/api/v1/atencion")
public class AtencionController {

    @Autowired
    private AtencionService atencionService;

    @GetMapping
    public ResponseEntity<List<Atencion>> listar(){
        List<Atencion> atenciones = atencionService.findAll();

        if(atenciones.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(atenciones);
    }

    @PostMapping
    public ResponseEntity<Atencion> guardar(@RequestBody Atencion atencion){
        Atencion nuevAtencion = atencionService.save(atencion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevAtencion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atencion> buscar(@PathVariable Integer id){
        try {
            Atencion atencion = atencionService.findById(id);
            return ResponseEntity.ok(atencion);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atencion> actualizar(@PathVariable Integer id, @RequestBody Atencion atencion){
        try {
            Atencion aten = atencionService.findById(id);

            aten.setId(id);
            aten.setCosto(atencion.getCosto());
            aten.setFechaAtencion(atencion.getFechaAtencion());
            aten.setHoraAtencion(atencion.getHoraAtencion());
            aten.setPaciente(atencion.getPaciente());

            atencionService.save(aten);
            return ResponseEntity.ok(atencion);

        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id){
        try {
            atencionService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
