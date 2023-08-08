package com.TiendaClase.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public interface FirebaseStorageService {
    public String cargaImagen(MultipartFile archivoLocalClirnte, String carpeta, Long id);
    
    
    final String BucketName = "techshop-d75c.appspot.com";
    
    final String rutaSuperiorStorage = "techshop";

    final String rutaJsonFile = "firebase";    
    
    final String archivoJsonFile = "techshop-d75ce-firebase-adminsdk-w7nuy-fda1fe3832.json";
}
