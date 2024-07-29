/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reposteria_patri.services.impl;

import com.reposteria_patri.dao.ContactoDao;
import com.reposteria_patri.domain.Contacto;
import com.reposteria_patri.services.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jordy
 */
@Service
    public class ContactoServiceImpl implements ContactoService {
    
    @Autowired
    private ContactoDao contactoDao;

   
    @Override
    @Transactional
    public void save(Contacto contacto) {
        contactoDao.save(contacto);
    }

    @Override
    @Transactional
    public void delete(Contacto contacto) {
        contactoDao.delete(contacto);
    }

    @Override
        @Transactional(readOnly = true)

    public Contacto getContacto(Contacto contacto) {
        return contactoDao.findById(contacto.getIdCliente()).orElse(null);
    }
}
