package com.alfajor.gestion_cupcakes.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductoDTO {

    private Long id;
    private String name;
    private Integer precio;
    private Double pesoEnGramos;

    public ProductoDTO(Long id, String name, Integer precio, Double pesoEnGramos) {
        this.id = id;
        this.name = name;
        this.precio = precio;
        this.pesoEnGramos = pesoEnGramos;
    }
}
