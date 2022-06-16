/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gob.hospitalchosica.atencion.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.hospitalchosica.atencion.config.RestTemplateConfig;
import pe.gob.hospitalchosica.atencion.entity.Atencion;
import pe.gob.hospitalchosica.atencion.model.Medico;
import pe.gob.hospitalchosica.atencion.model.Paciente;
import pe.gob.hospitalchosica.atencion.repository.AtencionRepository;
/**
 *
 * @author dmanrique
 */
@Service
public class AtencionService {
    
    @Autowired
    AtencionRepository atencionRepository;
    
    @Autowired
    RestTemplateConfig restTemplate;
    
    public List<Atencion> getAll(){
        return atencionRepository.findAll();
    }
    
    public Atencion getAtencionById(Long id){
        return atencionRepository.findById(id).orElse(null);
    }
    
    public Atencion save(Atencion atencion){
        Atencion atencionNuevo=atencionRepository.save(atencion);
        return atencionNuevo;
    }
    
    public List<Atencion> getByMedicoId(Long medicoId){
        return atencionRepository.findByMedicoId(medicoId);
    }
    
    public List<Atencion> getByPacienteId(Long pacienteId){
        return atencionRepository.findByMedicoId(pacienteId);
    }
    
    public Paciente getPaciente(Long id){
        Paciente  paciente= restTemplate.restTemplate().getForObject("http://localhost:8001/paciente/"+id, Paciente.class);
        return paciente;
    }
    public Medico getMedico(Long id){
        Medico  medico= restTemplate.restTemplate().getForObject("http://localhost:8002/medico/"+id, Medico.class);
        return medico;
    }
}
