/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reposteria_patri.domain;


import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data //sets y gets 
@Entity
@Table(name="consulta") //nombrar la tabla
public class Contacto {
    
    private static final long serialVersionUID = 1L;
    
    @Id //indicar que el siguiente atributo es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCliente")
    private Long idCliente; // Anteriormente `id_comment`

    private String nombre;
    private String apellido;
    private String username;
    private String city;
    private String state;
    private double zip;
    private String correo;
    private double telefono;
    private String mensaje;



}
