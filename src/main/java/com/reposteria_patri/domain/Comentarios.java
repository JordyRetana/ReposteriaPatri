
package com.reposteria_patri.domain;


import jakarta.persistence.*;
import lombok.Data;
@Data 
@Entity
@Table(name="comentarios") 
public class Comentarios {
      
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idClientePreguntas")
    private Long idClientePreguntas; 

    private String nombre;
    private String apellido;
    private String comentario;

    // Este campo se usa para almacenar la URL de la imagen
    private String imagen;
}
