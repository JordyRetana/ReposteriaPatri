package com.reposteria_patri.domain;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="rol") 
public class Rol {
    
    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_rol")
    private long idRol;
    private String nombre;
    @Column(name="id_usuario")
    private Long idUsuario;
    
}
