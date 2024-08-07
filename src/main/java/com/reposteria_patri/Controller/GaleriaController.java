package com.reposteria_patri.Controller;


import com.reposteria_patri.domain.Galeria;
import com.reposteria_patri.services.GaleriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/galeria")
public class GaleriaController {

    @Autowired
    private GaleriaService galeriaService;

    @GetMapping("/listado")
    public String mostrarListadoGaleria(Model model) {
        List<Galeria> imagenes = galeriaService.obtenerTodasLasImagenes();
        model.addAttribute("imagenes", imagenes);
        return "galeria/listado";
    }
}
