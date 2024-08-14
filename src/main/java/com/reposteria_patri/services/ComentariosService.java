package com.reposteria_patri.services;

import com.reposteria_patri.domain.Comentarios;
import java.util.List;

public interface ComentariosService {
    List<Comentarios> getPreguntases();
    Comentarios getPreguntas(Comentarios preguntas);
    void savePreguntas(Comentarios preguntas); // Añadir método para guardar preguntas
}
