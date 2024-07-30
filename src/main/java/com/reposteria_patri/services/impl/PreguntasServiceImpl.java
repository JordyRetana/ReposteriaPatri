package com.reposteria_patri.services.impl;

import com.reposteria_patri.domain.Preguntas;
import com.reposteria_patri.dao.PreguntasDao;
import com.reposteria_patri.services.PreguntasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntasServiceImpl implements PreguntasService {

    @Autowired
    private PreguntasDao preguntasRepository;

    @Override
    public List<Preguntas> getPreguntases() {
        return preguntasRepository.findAll();
    }

    @Override
    public Preguntas getPreguntas(Preguntas preguntas) {
        return preguntasRepository.findById(preguntas.getIdClientePreguntas()).orElse(null);
    }

    @Override
    public void savePreguntas(Preguntas preguntas) {
        preguntasRepository.save(preguntas);
    }
}
