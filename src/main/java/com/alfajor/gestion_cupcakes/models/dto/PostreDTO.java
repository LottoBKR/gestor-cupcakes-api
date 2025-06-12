package com.alfajor.gestion_cupcakes.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PostreDTO {

    private Long id;
    private String name;
    private Integer precioPorUnidad;
    private List<IngredienteDTO> ingredientes;

    public PostreDTO(Long id, String name, Integer precioPorUnidad, List<IngredienteDTO> ingredientes) {
        this.id = id;
        this.name = name;
        this.precioPorUnidad = precioPorUnidad;
        this.ingredientes = ingredientes;
    }
}
