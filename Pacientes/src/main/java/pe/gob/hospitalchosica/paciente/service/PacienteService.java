/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gob.hospitalchosica.paciente.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.hospitalchosica.paciente.repository.PacienteRepository;
import pe.gob.hospitalchosica.paciente.entity.Paciente;
/**
 *
 * @author dmanrique
 */
@Service
public class PacienteService {
    
    @Autowired
    PacienteRepository pacienteRepository;
    
    
    public List<Paciente> getAll(){
        return pacienteRepository.findAll();
    }
    
    public Paciente getPacienteById(Long id){
        return pacienteRepository.findById(id).orElse(null);
    }
    
    public Paciente save(Paciente paciente){
        Paciente pacienteNuevo=pacienteRepository.save(paciente);
        return pacienteNuevo;
    }
}
