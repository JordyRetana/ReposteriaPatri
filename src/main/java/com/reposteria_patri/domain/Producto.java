/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reposteria_patri.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data //sets y gets 
@Entity
@Table(name="producto")
public class Producto {
    @Id //indicar que el siguiente atributo es la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private long idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int existencias;
    private String imagen;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;
}
