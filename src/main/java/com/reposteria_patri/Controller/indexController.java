package com.reposteria_patri.Controller;
import com.reposteria_patri.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/")
    public String inicio(Model model){
        var productos = productoService.getProductos();
        model.addAttribute("productos",productos);
        
        return "index";
    }
}

