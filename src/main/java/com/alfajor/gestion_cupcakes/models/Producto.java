package com.alfajor.gestion_cupcakes.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data @AllArgsConstructor @NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String name;
    @Min(value = 1, message = "El precio debe ser mayor a 0")
    private Integer precio;
    @Min(value = 1, message = "El peso debe ser mayor a 0")
    private Double pesoEnGramos;

}
