
package com.tienda.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {
    
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);
        final String BucketName = "techshop-5feb1.appspot.com";
        
        final String rutaSuperiorStorage = "techshop";
        
        final String rutaJsonFile = "firebase";
        
        final String archivoJsonFile = "techshop-5feb1-firebase-adminsdk-vvd9h-ab89ac3ae1";
    

   
}
