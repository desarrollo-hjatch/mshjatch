/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gob.hospitalchosica.medico.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.hospitalchosica.medico.service.MedicoService;
import pe.gob.hospitalchosica.medico.entity.Medico;

/**
 *
 * @author dmanrique
 */
@RestController
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    MedicoService medicoService;
    
    @GetMapping
    public ResponseEntity<List<Medico>> getAll(){
        List<Medico> medicos = medicoService.getAll();
        if(medicos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(medicos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Medico> getById(@PathVariable("id") Long id){
        Medico medico = medicoService.getMedicoById(id);
        if(medico == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(medico);
    }
    
    @PostMapping
    public ResponseEntity<Medico> save(@RequestBody Medico medico){
        Medico medicoNuevo = medicoService.save(medico);
        return ResponseEntity.ok(medicoNuevo);
    }
}
