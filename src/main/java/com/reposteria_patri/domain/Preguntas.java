/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reposteria_patri.domain;

/**
 *
 * @author Jordy
 */



import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data //sets y gets 
@Entity
@Table(name="preguntas") //nombrar la tabla
    
public class Preguntas {
      
    @Id //indicar que el siguiente atributo es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idClientePreguntas")
    private Long idClientePreguntas; 
    private String nombre;
    private String apellido;
    private String comentario;
    private String imagen;
}
