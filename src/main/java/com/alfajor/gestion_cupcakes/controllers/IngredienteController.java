package com.alfajor.gestion_cupcakes.controllers;

import com.alfajor.gestion_cupcakes.models.Ingrediente;
import com.alfajor.gestion_cupcakes.models.dto.IngredienteDTO;
import com.alfajor.gestion_cupcakes.services.IngredienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping
    public ResponseEntity<?> getAllIngredientes() {
        return ingredienteService.allIngredientesResponse();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIngredienteById(@PathVariable Long id) {
        return getIngredienteById(id);
    }

    @PostMapping
    public ResponseEntity<?> createIngrediente(@Valid @RequestBody Ingrediente ingrediente) {
        return ingredienteService.createIngredienteResponse(ingrediente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateIngrediente(@PathVariable String id,@Valid @RequestBody Ingrediente ingrediente) {
        return ingredienteService.updateIngredienteResponse(id, ingrediente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIngrediente(@PathVariable String id) {
        return ingredienteService.deleteIngredienteResponse(id);
    }

}
