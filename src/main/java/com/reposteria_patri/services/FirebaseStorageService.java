/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.reposteria_patri.services;
import org.springframework.web.multipart.MultipartFile;
public interface FirebaseStorageService {
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    final String BucketName = "reposteriapatri-cca54.appspot.com";

    final String rutaSuperiorStorage = "ReposteriaPatri";

    final String rutaJsonFile = "firebase";
    
    final String archivoJsonFile = "reposteriapatri-cca54-firebase-adminsdk-r84nb-2458859b12.json";
    
}
