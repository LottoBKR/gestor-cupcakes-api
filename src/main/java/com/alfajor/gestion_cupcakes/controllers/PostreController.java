package com.alfajor.gestion_cupcakes.controllers;

import com.alfajor.gestion_cupcakes.models.Postre;
import com.alfajor.gestion_cupcakes.services.PostreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postres")
public class PostreController {

    @Autowired
    private PostreService postreService;

    @GetMapping
    public ResponseEntity<?> getAllPostres(){
        return postreService.allPostresResponse();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPostreById(@PathVariable Long id) {
        return postreService.getPostreByIdResponse(id);
    }

    @PostMapping
    public ResponseEntity<?> createPostre(@Valid @RequestBody Postre postre) {
        return postreService.createPostreResponse(postre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePostre(@PathVariable Long id,@Valid @RequestBody Postre postre) {
        return postreService.updatePostreResponse(id, postre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePostre(@PathVariable Long id) {
        return postreService.deletePostreResponse(id);
    }
}
