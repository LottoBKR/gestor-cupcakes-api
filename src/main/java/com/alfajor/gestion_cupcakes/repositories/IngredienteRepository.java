package com.alfajor.gestion_cupcakes.repositories;

import com.alfajor.gestion_cupcakes.models.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, String> {

}
