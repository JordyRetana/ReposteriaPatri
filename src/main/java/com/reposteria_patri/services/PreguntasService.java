package com.reposteria_patri.services;

import com.reposteria_patri.domain.Preguntas;
import java.util.List;

public interface PreguntasService {
    List<Preguntas> getPreguntases();
    Preguntas getPreguntas(Preguntas preguntas);
    void savePreguntas(Preguntas preguntas); // Añadir método para guardar preguntas
}
