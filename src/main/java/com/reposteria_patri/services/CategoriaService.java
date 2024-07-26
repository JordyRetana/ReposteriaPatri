package com.reposteria_patri.services;

import com.reposteria_patri.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    //se recupera la lista de categorias de la tabla categoria dentro de un ArrayList
    //solo las activas o todas
    public List<Categoria> getCategorias();
    
    
    //se obtiene un registro de categorias de tipo categoria
    //si el idCategoria existe... si no existe es null
    //solo las activas o todas
    public Categoria getCategorias(Categoria categoria);
    
    
    
}
