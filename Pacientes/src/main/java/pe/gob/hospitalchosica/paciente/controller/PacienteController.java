/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gob.hospitalchosica.paciente.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.hospitalchosica.paciente.service.PacienteService;
import pe.gob.hospitalchosica.paciente.entity.Paciente;

/**
 *
 * @author dmanrique
 */
@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;
    
    @GetMapping
    public ResponseEntity<List<Paciente>> getAll(){
        List<Paciente> pacientes = pacienteService.getAll();
        if(pacientes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pacientes);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getById(@PathVariable("id") Long id){
        Paciente paciente = pacienteService.getPacienteById(id);
        if(paciente == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(paciente);
    }
    
    @PostMapping
    public ResponseEntity<Paciente> save(@RequestBody Paciente paciente){
        Paciente pacienteNuevo = pacienteService.save(paciente);
        return ResponseEntity.ok(pacienteNuevo);
    }
}
