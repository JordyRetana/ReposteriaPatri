/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reposteria_patri.Controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Jordy
 */
public class ComentariosController {
       @GetMapping("/comentarios/listado")
    public String mostrarListadoComentarios() {
        return "comentarios/listado";
    }
}
