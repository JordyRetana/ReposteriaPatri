package com.reposteria_patri.services.impl;

import com.reposteria_patri.dao.ProductoDao;
import com.reposteria_patri.domain.Producto;
import com.reposteria_patri.services.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoDao productoDao;
    
    @Override
    public List<Producto> getProductos() {
        var lista = productoDao.findAll();
        
        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Producto getProductos(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    
    @Override
    public Producto consultaProducto(Long idProducto){
        return productoDao.findById(idProducto).orElse(null);
    }
    
}
