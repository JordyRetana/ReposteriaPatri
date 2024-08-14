package com.reposteria_patri.services.impl;

import com.reposteria_patri.domain.Comentarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.reposteria_patri.dao.ComentariosDao;
import com.reposteria_patri.services.ComentariosService;

@Service
public class ComentariosServiceImpl implements ComentariosService {

    @Autowired
    private ComentariosDao preguntasRepository;

    @Override
    public List<Comentarios> getPreguntases() {
        return preguntasRepository.findAll();
    }

    @Override
    public Comentarios getPreguntas(Comentarios preguntas) {
        return preguntasRepository.findById(preguntas.getIdClientePreguntas()).orElse(null);
    }

    @Override
    public void savePreguntas(Comentarios preguntas) {
        preguntasRepository.save(preguntas);
    }
}
