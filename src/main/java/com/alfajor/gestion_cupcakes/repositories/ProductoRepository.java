package com.alfajor.gestion_cupcakes.repositories;

import com.alfajor.gestion_cupcakes.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
