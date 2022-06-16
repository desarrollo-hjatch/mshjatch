/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gob.hospitalchosica.atencion.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author dmanrique
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medico {
    private String nombre;
    private String apellidos;
    private String especialidad;
}