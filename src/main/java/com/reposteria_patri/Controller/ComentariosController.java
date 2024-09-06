package com.reposteria_patri.Controller;

import com.reposteria_patri.domain.Comentarios;
import com.reposteria_patri.services.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import com.reposteria_patri.services.ComentariosService;

@Controller
@RequestMapping("/comentarios")
public class ComentariosController {

    @Autowired
    private ComentariosService comentariosService;

    @Autowired
    private FirebaseStorageService firebaseStorageService;
    @GetMapping("/listado")
    public String mostrarListadoComentarios(Model model) {
        List<Comentarios> preguntas = comentariosService.getPreguntases();
        model.addAttribute("preguntas", preguntas);
        return "comentarios/listado";
    }


@PostMapping("/submitTestimonio")
public String submitTestimonio(Comentarios comentarios,
                               @RequestParam("imagenFile") MultipartFile imagenFile) {

    comentariosService.savePreguntas(comentarios);

    if (!imagenFile.isEmpty()) {
        try {
            Long comentarioId = comentarios.getIdClientePreguntas();

            String urlImagen = firebaseStorageService.cargaImagen(imagenFile, "comentarios", comentarioId);

            comentarios.setImagen(urlImagen);
            comentariosService.savePreguntas(comentarios);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    return "redirect:/comentarios/listado";
}


    
}
