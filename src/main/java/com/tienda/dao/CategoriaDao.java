package com.tienda.dao;

import com.tienda.domain.Categoria;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository <Categoria,Long> {
    
    List<Categoria> findAll();

    public Optional<Categoria> findById(Long id);
    
    
}
