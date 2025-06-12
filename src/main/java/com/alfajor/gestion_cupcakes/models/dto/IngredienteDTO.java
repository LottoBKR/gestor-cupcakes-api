package com.alfajor.gestion_cupcakes.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IngredienteDTO {

    private String name;
    private Double gramosUsados;
    private Integer precioPorUso;;

    public IngredienteDTO(String name, Integer precioPorUso, Double gramosUsados){
        this.name = name;
        this.precioPorUso = precioPorUso;
        this.gramosUsados = gramosUsados;
    }
}
