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
@Table(name = "postres")
@Data @AllArgsConstructor @NoArgsConstructor
public class Postre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String name;
    @OneToMany(mappedBy = "postre")
    private List<IngredientesDelPostre> ingredientes = new ArrayList<>();
    @Min(value = 1, message = "El precio debe ser mayor a 0")
    private Integer precioPorUnidad;

}
