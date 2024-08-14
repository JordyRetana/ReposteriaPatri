package com.reposteria_patri.Controller;

import com.reposteria_patri.domain.Preguntas;
import com.reposteria_patri.services.FirebaseStorageService;
import com.reposteria_patri.services.PreguntasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Controller
@RequestMapping("/comentarios")
public class ComentariosController {

    @Autowired
    private PreguntasService preguntasService;

    @GetMapping("/listado")
    public String mostrarListadoComentarios(Model model) {
        List<Preguntas> preguntas = preguntasService.getPreguntases();
        model.addAttribute("preguntas", preguntas);
        return "comentarios/listado";
    }
    @Autowired
    private FirebaseStorageService firebaseStorageService;
    @PostMapping("/submitTestimonio")
    public String submitTestimonio(Preguntas comentario, @RequestParam("imagen") MultipartFile imagen){
        
        if (!imagen.isEmpty()){            
            String rutaImagen = 
                    firebaseStorageService.cargaImagen(imagen, "comentario", comentario.getIdClientePreguntas());
            comentario.setImagen(rutaImagen);
        }
        preguntasService.savePreguntas(comentario);
                
        return "redirect:/comentarios/listado";
    }
    
}
