package com.alfajor.gestion_cupcakes.controllers;

import com.alfajor.gestion_cupcakes.models.Postre;
import com.alfajor.gestion_cupcakes.models.Producto;
import com.alfajor.gestion_cupcakes.services.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<?> getAllPostres(){
        return productoService.allProductosResponse();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPostreById(@PathVariable Long id) {
        return productoService.getProductoByIdResponse(id);
    }

    @PostMapping
    public ResponseEntity<?> createPostre(@Valid @RequestBody Producto producto) {
        return productoService.createProductoResponse(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePostre(@PathVariable Long id,@Valid @RequestBody Producto producto) {
        return productoService.updateProductoResponse(id, producto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePostre(@PathVariable Long id) {
        return productoService.deleteProductoResponse(id);
    }
}
