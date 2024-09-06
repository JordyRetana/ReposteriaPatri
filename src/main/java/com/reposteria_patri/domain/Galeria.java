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

@Data 
@Entity
@Table(name="galerias")
public class Galeria {
    
    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idImagen")
    private long idImagen;

    private String imagen;

}
