/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gob.hospitalchosica.medico.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.hospitalchosica.medico.repository.MedicoRepository;
import pe.gob.hospitalchosica.medico.entity.Medico;
/**
 *
 * @author dmanrique
 */
@Service
public class MedicoService {
    
    @Autowired
    MedicoRepository medicoRepository;
    
    
    public List<Medico> getAll(){
        return medicoRepository.findAll();
    }
    
    public Medico getMedicoById(Long id){
        return medicoRepository.findById(id).orElse(null);
    }
    
    public Medico save(Medico medico){
        Medico medicoNuevo=medicoRepository.save(medico);
        return medicoNuevo;
    }
}
