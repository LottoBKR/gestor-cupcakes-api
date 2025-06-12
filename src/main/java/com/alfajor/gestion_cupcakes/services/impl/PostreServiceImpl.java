package com.alfajor.gestion_cupcakes.services.impl;

import com.alfajor.gestion_cupcakes.models.Ingrediente;
import com.alfajor.gestion_cupcakes.models.Postre;
import com.alfajor.gestion_cupcakes.models.dto.IngredienteDTO;
import com.alfajor.gestion_cupcakes.models.dto.PostreDTO;
import com.alfajor.gestion_cupcakes.repositories.PostreRepository;
import com.alfajor.gestion_cupcakes.services.PostreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostreServiceImpl implements PostreService {

    @Autowired
    private PostreRepository postreRepository;

    @Override
    public ResponseEntity<?> allPostresResponse(){
        List<PostreDTO> postres = getAllPostres();
        if (postres.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.ok(postres); // 200 OK
        }
    }

    @Override
    public ResponseEntity<?> getPostreByIdResponse(Long id){
        PostreDTO p = getPostreById(id);
        return p != null ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> createPostreResponse(Postre postre){
        try {
            PostreDTO created = createPostre(postre);
            return ResponseEntity.ok(created); // 200 OK
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build(); // 400 Bad Request si no se logra crear
        }
    }

    @Override
    public ResponseEntity<?> updatePostreResponse(Long id, Postre postre){
        try {
            PostreDTO created = createPostre(postre);
            return ResponseEntity.ok(created); // 200 OK
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build(); // 400 Bad Request si no se logra crear
        }
    }

    @Override
    public ResponseEntity<?> deletePostreResponse(Long id){
        try {
            deletePostre(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    private List<PostreDTO> getAllPostres() {
        return postreRepository.findAll().stream().map(this::toDto).toList();
    }

    private PostreDTO getPostreById(Long id) {
        return toDto(postreRepository.findById(id).orElse(null));
    }

    private PostreDTO createPostre(Postre postre) {
        return toDto(postreRepository.save(postre));
    }

    private PostreDTO updatePostre(Long id, Postre updated) {
        Optional<Postre> optionalPostre = postreRepository.findById(id);
        if (optionalPostre.isEmpty()){
            throw new IllegalArgumentException("El postre con ID " + id + " no existe.");
        }
        Postre postre = optionalPostre.get();
        postre.setName(updated.getName());
        postre.setPrecioPorUnidad(updated.getPrecioPorUnidad());
        postre.setIngredientes(updated.getIngredientes());
        return toDto(postre);
    }

    private void deletePostre(Long id) {
        postreRepository.deleteById(id);
    }

    private PostreDTO toDto(Postre postre){
        List<IngredienteDTO> ingredientes = ingredientesToDto(postre);
        return new PostreDTO(postre.getId(), postre.getName(), postre.getPrecioPorUnidad(), ingredientes);
    }

    private IngredienteDTO toDto(Ingrediente ingrediente){
        return new IngredienteDTO(ingrediente.getName(), ingrediente.getPrecioPorUso(), ingrediente.getGramosUsados());
    }

    private List<IngredienteDTO> ingredientesToDto(Postre postre){
        List<IngredienteDTO> ingredientes = new ArrayList<>();
        postre.getIngredientes().forEach(i -> {
            ingredientes.add(toDto(i.getIngrediente()));
        });
        return ingredientes;
    }


}
