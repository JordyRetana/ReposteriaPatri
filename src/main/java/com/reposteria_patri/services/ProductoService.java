package com.reposteria_patri.services;

import com.reposteria_patri.domain.Producto;
import java.util.List;

public interface ProductoService {
    
    
    public List<Producto> getProductos();
    
    
   
    public Producto getProductos(Producto producto);
    
 
    public void save(Producto producto);
    
    public void delete(Producto producto);
    
    public Producto consultaProducto(Long idProducto);
}
