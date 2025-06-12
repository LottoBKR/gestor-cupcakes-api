package com.alfajor.gestion_cupcakes.services;

import com.alfajor.gestion_cupcakes.models.Ingrediente;
import com.alfajor.gestion_cupcakes.models.Postre;
import org.springframework.http.ResponseEntity;

public interface IngredienteService {

    ResponseEntity<?> allIngredientesResponse();
    ResponseEntity<?> getIngredienteByIdResponse(String id);
    ResponseEntity<?> createIngredienteResponse(Ingrediente ingrediente);
    ResponseEntity<?> updateIngredienteResponse(String id, Ingrediente ingrediente);
    ResponseEntity<?> deleteIngredienteResponse(String id);
}
