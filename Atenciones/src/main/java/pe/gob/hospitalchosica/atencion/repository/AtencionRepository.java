/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.gob.hospitalchosica.atencion.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.gob.hospitalchosica.atencion.entity.Atencion;
/**
 *
 * @author dmanrique
 */
@Repository
public interface AtencionRepository extends JpaRepository<Atencion, Long>{
    List<Atencion> findByMedicoId(Long medicoId);
    List<Atencion> findByPacienteId(Long medicoId);
}
