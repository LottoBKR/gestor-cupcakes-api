package com.alfajor.gestion_cupcakes.services;

import com.alfajor.gestion_cupcakes.models.Postre;
import com.alfajor.gestion_cupcakes.models.dto.PostreDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostreService {

    ResponseEntity<?> allPostresResponse();
    ResponseEntity<?> getPostreByIdResponse(Long id);
    ResponseEntity<?> createPostreResponse(Postre postre);
    ResponseEntity<?> updatePostreResponse(Long id, Postre postre);
    ResponseEntity<?> deletePostreResponse(Long id);
}
