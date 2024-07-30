package com.reposteria_patri.Controller;

import com.reposteria_patri.domain.Preguntas;
import com.reposteria_patri.services.PreguntasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
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

@PostMapping("/submitTestimonio")
public String submitTestimonio(@RequestParam("nombre") String nombre,
                               @RequestParam("apellido") String apellido,
                               @RequestParam("comentario") String comentario,
                               @RequestParam("imagen") MultipartFile imagen,
                               Model model) {
    try {
        Preguntas preguntas = new Preguntas();
        preguntas.setNombre(nombre);
        preguntas.setApellido(apellido);
        preguntas.setComentario(comentario);

        if (!imagen.isEmpty()) {
            // Convertir la imagen a una cadena Base64
            String base64Image = Base64.getEncoder().encodeToString(imagen.getBytes());
            // Asignar la cadena Base64 a la propiedad de la imagen
            preguntas.setImagen(base64Image);
        }
        // Guardar el testimonio
        preguntasService.savePreguntas(preguntas);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return "redirect:/comentarios/listado";
}


}
