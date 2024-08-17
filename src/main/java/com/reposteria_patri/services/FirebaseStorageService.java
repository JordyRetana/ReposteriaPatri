/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reposteria_patri.services;
import org.springframework.web.multipart.MultipartFile;
public interface FirebaseStorageService {
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "reposteriapatri-cca54.appspot.com";

    //Esta es la ruta básica de este proyecto Reposteria Patri
    final String rutaSuperiorStorage = "ReposteriaPatri";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "reposteriapatri-cca54-firebase-adminsdk-r84nb-50c4108c0c.json";
    
}
