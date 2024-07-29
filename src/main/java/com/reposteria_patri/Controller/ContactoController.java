package com.reposteria_patri.controller;

import com.reposteria_patri.domain.Contacto;
import com.reposteria_patri.services.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

    @Autowired
    private ContactoService contactoService;
    
        @GetMapping("/listado")
       public String listarContacto(Model model) {
        model.addAttribute("contacto", new Contacto()); // Agrega el objeto 'contacto'
        return "contacto/listado";
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "contacto/formulario";
    }

    @PostMapping("/guardar")
    public String guardarContacto(@ModelAttribute("contacto") Contacto contacto) {
        contactoService.save(contacto);
        return "redirect:/contacto/listado";
    }
}
