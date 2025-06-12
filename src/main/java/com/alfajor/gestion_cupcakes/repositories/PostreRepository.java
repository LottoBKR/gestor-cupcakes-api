package com.alfajor.gestion_cupcakes.repositories;

import com.alfajor.gestion_cupcakes.models.Postre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostreRepository extends JpaRepository<Postre, Long> {
}
