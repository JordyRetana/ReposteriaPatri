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
        

    public Contacto getContacto(Contacto contacto);
    
    
    public void save(Contacto contacto);
    
    public void delete(Contacto contacto);
}
