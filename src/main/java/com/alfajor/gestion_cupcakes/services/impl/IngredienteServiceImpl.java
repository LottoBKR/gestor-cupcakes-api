package com.alfajor.gestion_cupcakes.services.impl;

import com.alfajor.gestion_cupcakes.models.Ingrediente;
import com.alfajor.gestion_cupcakes.models.Postre;
import com.alfajor.gestion_cupcakes.models.dto.IngredienteDTO;
import com.alfajor.gestion_cupcakes.repositories.IngredienteRepository;
import com.alfajor.gestion_cupcakes.services.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteServiceImpl implements IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Override
    public ResponseEntity<?> allIngredientesResponse(){
        List<IngredienteDTO> ingrediente = getIngredientes();
        if (ingrediente.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.ok(ingrediente); // 200 OK
        }
    }
    @Override
    public ResponseEntity<?> getIngredienteByIdResponse(String id){
        IngredienteDTO i = getIngrediente(id);
        return i != null ? ResponseEntity.ok(i) : ResponseEntity.notFound().build();
    }
    @Override
    public ResponseEntity<?> createIngredienteResponse(Ingrediente ingrediente){
        try {
            IngredienteDTO created = createIngrediente(ingrediente);
            return ResponseEntity.ok(created); // 200 OK
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build(); // 400 Bad Request si no se logra crear
        }
    }
    @Override
    public ResponseEntity<?> updateIngredienteResponse(String id, Ingrediente ingrediente){
        try {
            IngredienteDTO updated = updateIngrediente(id, ingrediente);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found si no existe
        }
    }
    @Override
    public ResponseEntity<?> deleteIngredienteResponse(String id){
        try {
            deleteIngrediente(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    private List<IngredienteDTO> getIngredientes() {
        return ingredienteRepository.findAll().stream().map(this::toDto).toList();
    }

    private IngredienteDTO getIngrediente(String id) {
        return toDto(ingredienteRepository.findById(id).orElse(null));
    }

    private IngredienteDTO createIngrediente(Ingrediente ingrediente) {
        return toDto(ingredienteRepository.save(ingrediente));
    }

    private IngredienteDTO updateIngrediente(String id, Ingrediente updated) {
        Optional<Ingrediente> optionalIngrediente = ingredienteRepository.findById(id);
        if (optionalIngrediente.isEmpty()) {
            throw new IllegalArgumentException("El ingrediente con ID " + id + " no existe.");
        }
        Ingrediente ingrediente = optionalIngrediente.get();
        ingrediente.setPrecioPorUso(updated.getPrecioPorUso());
        ingrediente.setGramosUsados(updated.getGramosUsados());
        ingrediente.setPostres(updated.getPostres());
        return toDto(ingredienteRepository.save(ingrediente));
    }

    private void deleteIngrediente(String id) {
        ingredienteRepository.deleteById(id);
    }

    private IngredienteDTO toDto(Ingrediente ingrediente){
        return new IngredienteDTO(ingrediente.getName(), ingrediente.getPrecioPorUso(), ingrediente.getGramosUsados());
    }
}
