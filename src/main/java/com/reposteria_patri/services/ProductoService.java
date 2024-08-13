package com.reposteria_patri.services;

import com.reposteria_patri.domain.Producto;
import java.util.List;

public interface ProductoService {
    
    //se recupera la lista de productos de la tabla producto dentro de un ArrayList
    //solo las activas o todas
    public List<Producto> getProductos();
    
    
    //se obtiene un registro de productos de tipo producto
    //si el idProducto existe... si no existe es null
    //solo las activas o todas
    public Producto getProductos(Producto producto);
    
    //se crea un nuevo registro en la tabla producto si el objeto producto NO tiene idProducto
    //se actualiza el registro en la tabla de producto,
    //si el objeto Producto tiene un idProducto.    
    public void save(Producto producto);
    
    //Se elimina el registro en la tabla de producto si el idProducto  del objeto existe en la tabla
    public void delete(Producto producto);
    
    public Producto consultaProducto(Long idProducto);
}
