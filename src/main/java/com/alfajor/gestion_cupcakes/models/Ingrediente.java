package com.alfajor.gestion_cupcakes.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredientes")
@Data @NoArgsConstructor @AllArgsConstructor
public class Ingrediente {

    @Id
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String name;
    private Double gramosUsados;
    private Integer precioPorUso;
    @OneToMany(mappedBy = "ingrediente")
    private List<IngredientesDelPostre> postres = new ArrayList<>();

}
