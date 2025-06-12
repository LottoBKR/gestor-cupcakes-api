package com.alfajor.gestion_cupcakes.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ingredientes_del_postre")
@Data @AllArgsConstructor @NoArgsConstructor
public class IngredientesDelPostre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Ingrediente ingrediente;
    @ManyToOne
    private Postre postre;
}
