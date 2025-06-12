package com.alfajor.gestion_cupcakes.services.impl;

import com.alfajor.gestion_cupcakes.models.Producto;
import com.alfajor.gestion_cupcakes.models.dto.PostreDTO;
import com.alfajor.gestion_cupcakes.models.dto.ProductoDTO;
import com.alfajor.gestion_cupcakes.repositories.ProductoRepository;
import com.alfajor.gestion_cupcakes.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public ResponseEntity<?> allProductosResponse() {
        List<ProductoDTO> postres = getAllProductos();
        if (postres.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.ok(postres); // 200 OK
        }
    }

    @Override
    public ResponseEntity<?> getProductoByIdResponse(Long id) {
        ProductoDTO p = getProductoById(id);
        return p != null ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<?> createProductoResponse(Producto producto) {
        try {
            ProductoDTO created = createProducto(producto);
            return ResponseEntity.ok(created); // 200 OK
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build(); // 400 Bad Request si no se logra crear
        }
    }

    @Override
    public ResponseEntity<?> updateProductoResponse(Long id, Producto producto) {
        try {
            ProductoDTO created = createProducto(producto);
            return ResponseEntity.ok(created); // 200 OK
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build(); // 400 Bad Request si no se logra crear
        }
    }

    @Override
    public ResponseEntity<?> deleteProductoResponse(Long id) {
        try {
            deleteProducto(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    private List<ProductoDTO> getAllProductos() {
        return productoRepository.findAll().stream().map(this::toDto).toList();
    }

    private ProductoDTO getProductoById(Long id) {
        return toDto(productoRepository.findById(id).orElse(null));
    }

    private ProductoDTO createProducto(Producto producto) {
        return toDto(productoRepository.save(producto));
    }

    private ProductoDTO updateProducto(Long id, Producto updated) {
        Optional<Producto> optionalPostre = productoRepository.findById(id);
        if (optionalPostre.isEmpty()){
            throw new IllegalArgumentException("El postre con ID " + id + " no existe.");
        }
        Producto producto = optionalPostre.get();
        producto.setName(updated.getName());
        producto.setPrecio(updated.getPrecio());
        producto.setPesoEnGramos(updated.getPesoEnGramos());
        return toDto(producto);
    }

    private void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    private ProductoDTO toDto(Producto producto){
        return new ProductoDTO(producto.getId(), producto.getName(), producto.getPrecio(), producto.getPesoEnGramos());
    }
}
