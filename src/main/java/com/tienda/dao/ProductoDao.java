
package com.tienda.dao;


import com.tienda.domain.Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoDao extends JpaRepository <Producto,Long>{
    
    List<Producto> findAll();

    public Optional<Producto> findById(Long id);


}
