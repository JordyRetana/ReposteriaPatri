
package com.reposteria_patri.domain;


import jakarta.persistence.*;
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
