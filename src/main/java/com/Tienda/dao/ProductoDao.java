package com.Tienda.dao;

import com.Tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductoDao extends JpaRepository <Producto,Long>{
   //Ejemplo de método utilizando métodos de consulta
public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup); 

@Query(value="SELECT a FROM Producto a WHERE a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

@Query(nativeQuery =true, 
        value="SELECT a FROM producto where producto.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")

public List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
}
