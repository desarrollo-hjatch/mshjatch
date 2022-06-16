/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.gob.hospitalchosica.paciente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.hospitalchosica.paciente.entity.Paciente;
/**
 *
 * @author dmanrique
 */
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
}
