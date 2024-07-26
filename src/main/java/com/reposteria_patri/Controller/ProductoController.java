package com.reposteria_patri.Controller;

import com.reposteria_patri.services.CategoriaService;
import com.reposteria_patri.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String mostrarListadoProductos(Model model) {
        var productos = productoService.getProductos();
        //productos.forEach(producto -> System.out.println(producto.getImagen()));
        model.addAttribute("productos",productos);
        model.addAttribute("totalProductos",productos.size());
        
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias",categorias);
        
        return "productos/listado";
    }
}
