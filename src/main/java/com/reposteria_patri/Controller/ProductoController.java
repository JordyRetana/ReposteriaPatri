package com.reposteria_patri.Controller;

import com.reposteria_patri.domain.Producto;
import com.reposteria_patri.services.CategoriaService;
import com.reposteria_patri.services.FirebaseStorageService;
import com.reposteria_patri.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @GetMapping("/listado")
    public String mostrarListadoProductos(Model model) {
        var productos = productoService.getProductos();
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        addCategoriaModel(model);
        return "productos/listado";
    }

    @PostMapping("/agregar")
    public String agregar(Producto producto, @RequestParam("imagenFile") MultipartFile imagenFile) {
        productoService.save(producto);

        if (!imagenFile.isEmpty()) {
            try {
                Long productoId = producto.getIdProducto();

                String urlImagen = firebaseStorageService.cargaImagen(imagenFile, "productos", productoId);

                producto.setImagen(urlImagen);
                productoService.save(producto);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (producto.getCategoria().getIdCategoria() == 1) { // Tortas y Postres
            return "redirect:/productos/listadoTortasPostres";
        } else if (producto.getCategoria().getIdCategoria() == 2) { // Panadería
            return "redirect:/productos/listadoPanaderia";
        }

        return "redirect:/productos/listado";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String eliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/";
    }

    @GetMapping("/modificar/{idProducto}")
    public String modifica(Producto producto, Model model) {
        producto = productoService.getProductos(producto);
        model.addAttribute("producto", producto);
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
        return "/productos/modifica";
    }

    @GetMapping("/listadoTortasPostres")
    public String listadoTortas(Model model) {
        var productos = productoService.getProductos().stream()
                .filter(producto -> producto.getCategoria().getIdCategoria() == 1)
                .toList();
        model.addAttribute("productos", productos);
        addCategoriaModel(model);
        return "productos/listado";
    }

    @GetMapping("/listadoPanaderia")
    public String listadoPanaderia(Model model) {
        var productos = productoService.getProductos().stream()
                .filter(producto -> producto.getCategoria().getIdCategoria() == 2)
                .toList();
        model.addAttribute("productos", productos);
        addCategoriaModel(model);
        return "productos/listado_1";
    }

    @GetMapping("detalles/{idProducto}")
    public String detallesProducto(@PathVariable("idProducto") Long idProducto, Model model) {
        Producto producto = productoService.consultaProducto(idProducto);
        model.addAttribute("producto", producto);
        return "productos/listado_2";
    }

    private void addCategoriaModel(Model model) {
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
    }
}
