package com.alfajor.gestion_cupcakes.repositories;

import com.alfajor.gestion_cupcakes.models.IngredientesDelPostre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientesPostreRepository extends JpaRepository<IngredientesDelPostre, Long> {
}
