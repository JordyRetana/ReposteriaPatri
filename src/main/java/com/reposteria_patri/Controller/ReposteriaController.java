/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reposteria_patri.Controller;

/**
 *
 * @author Jordy
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public class ReposteriaController{
    @Controller
@RequestMapping("/contacto")
public class ContactoController {

    @GetMapping("/fragmentos")
    public String mostrarFragmentos() {
        return "contacto/fragmentos";
    }
}

    
}
