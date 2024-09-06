package com.reposteria_patri.domain;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data //sets y gets 
@Entity
@Table(name="categoria") //nombrar la tabla
public class Categoria {
    
    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private long idCategoria;
    private String nombre;
    
    @OneToMany
    @JoinColumn(name="id_categoria", updatable = false)
    private List<Producto> productos;
}
