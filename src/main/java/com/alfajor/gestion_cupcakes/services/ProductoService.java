package com.alfajor.gestion_cupcakes.services;

import com.alfajor.gestion_cupcakes.models.Producto;
import org.springframework.http.ResponseEntity;

public interface ProductoService {

    ResponseEntity<?> allProductosResponse();
    ResponseEntity<?> getProductoByIdResponse(Long id);
    ResponseEntity<?> createProductoResponse(Producto producto);
    ResponseEntity<?> updateProductoResponse(Long id, Producto producto);
    ResponseEntity<?> deleteProductoResponse(Long id);
}
