/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reposteria_patri.services;
import com.reposteria_patri.domain.Contacto;

/**
 *
 * @author Jordy
 */
public interface ContactoService {
        
    //se obtiene un registro de categorias de tipo categoria
    //si el idCategoria existe... si no existe es null
    //solo las activas o todas
    public Contacto getContacto(Contacto contacto);
    
    //se crea un nuevo registro en la tabla categoria si el objeto categoria NO tiene idCategoria
    //se actualiza el registro en la tabla de categoria,
    //si el objeto Categoria tiene un idCategoria.    
    public void save(Contacto contacto);
    
    //Se elimina el registro en la tabla de categoria si el idCategoria  del objeto existe en la tabla
    public void delete(Contacto contacto);
}
