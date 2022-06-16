/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gob.hospitalchosica.atencion.controller;

import pe.gob.hospitalchosica.atencion.service.AtencionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.hospitalchosica.atencion.entity.Atencion;
import pe.gob.hospitalchosica.atencion.model.Medico;
import pe.gob.hospitalchosica.atencion.model.Paciente;

/**
 *
 * @author dmanrique
 */
@RestController
@RequestMapping("/atencion")
public class AtencionController {
    @Autowired
    AtencionService atencionService;
    
    @GetMapping
    public ResponseEntity<List<Atencion>> getAll(){
        List<Atencion> atencions = atencionService.getAll();
        if(atencions.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(atencions);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Atencion> getById(@PathVariable("id") Long id){
        Atencion atencion = atencionService.getAtencionById(id);
        if(atencion == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(atencion);
    }
    
    @PostMapping
    public ResponseEntity<Atencion> save(@RequestBody Atencion atencion){
        Atencion atencionNuevo = atencionService.save(atencion);
        return ResponseEntity.ok(atencionNuevo);
    }
    
    @GetMapping("/bymedico/{id}")
    public ResponseEntity<List<Atencion>> getAllByMedico(@PathVariable("id") Long id){
        List<Atencion> atenciones = atencionService.getByMedicoId(id);
        if(atenciones.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(atenciones);
    }
    
    @GetMapping("/bypaciente/{id}")
    public ResponseEntity<List<Atencion>> getAllByPaciente(@PathVariable("id") Long id){
        List<Atencion> atenciones = atencionService.getByPacienteId(id);
        if(atenciones.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(atenciones);
    }
    
    @GetMapping("/paciente/{id}")
    public ResponseEntity<Paciente> getPaciente(@PathVariable("id") Long id){
        Paciente paciente = atencionService.getPaciente(id);
        if(paciente == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(paciente);
    }
    
    @GetMapping("/medico/{id}")
    public ResponseEntity<Medico> getMedico(@PathVariable("id") Long id){
        Medico medico = atencionService.getMedico(id);
        if(medico == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(medico);
    }
}
