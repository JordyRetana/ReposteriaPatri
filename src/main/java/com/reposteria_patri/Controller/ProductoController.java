package com.reposteria_patri.Controller;

import com.reposteria_patri.domain.Producto;
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
    
    @GetMapping("/eliminar/{idProducto}")
    public String eliminar(Producto producto){
        productoService.delete(producto); 
        return "redirect:/producto/listado";        
    }
    
    
    @GetMapping("/modificar/{idProducto}")
    public String modifica(Producto producto, Model model){
        producto = productoService.getProductos(producto);
        model.addAttribute("producto", producto); 
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias",categorias);
        return "/producto/modifica";        
    }
    
    @GetMapping("/listadoTortasPostres")
    public String listadoTortas(Model model){
        var productos = productoService.getProductos().stream()
                .filter(producto ->producto.getCategoria().getIdCategoria()==1)
                .toList();
        model.addAttribute("productos", productos);
        return "productos/listado";
    }
    
    @GetMapping("/listadoPanaderia")
    public String listadoPanaderia(Model model){
        var productos = productoService.getProductos().stream()
                .filter(producto ->producto.getCategoria().getIdCategoria()==2)
                .toList();
        model.addAttribute("productos", productos);
        return "productos/listado_1";
    }
}
