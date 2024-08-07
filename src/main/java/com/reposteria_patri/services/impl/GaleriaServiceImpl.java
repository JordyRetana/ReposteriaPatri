/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reposteria_patri.services.impl;
import com.reposteria_patri.dao.GaleriaDao;
import com.reposteria_patri.domain.Galeria;
import com.reposteria_patri.services.GaleriaService;

/**
 *
 * @author Jordy
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GaleriaServiceImpl implements GaleriaService {

    @Autowired
    private GaleriaDao galeriaRepository;

    @Override
    public List<Galeria> obtenerTodasLasImagenes() {
        return galeriaRepository.findAll();
    }
}