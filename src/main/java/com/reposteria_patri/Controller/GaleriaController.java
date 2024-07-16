/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reposteria_patri.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Jordy
 */
@Controller

public class GaleriaController {
           @GetMapping("/galeria/listado")
    public String mostrarListadogaleria() {
        return "galeria/listado";
    }
}
