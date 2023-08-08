package com.tienda.service.impl;


import com.tienda.dao.ProductoDao;
import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private ProductoDao productoDao;
    
    @Override
    @Transactional (readOnly=true)
    public List<Producto> getProductos(boolean activos) {
      var lista = productoDao.findAll();
        if(activos){
            lista.removeIf(e -> !e.isActivo() );
        }
        return lista;        
    }

    
    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProducto(Producto producto) {
        return (List<Producto>) productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    // Lista de productos con precio entre pedidos por descripción ConsultaAmpliada

    @Override
    @Transactional(readOnly=true)
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
}

    @Override
    @Transactional(readOnly=true)    
    public List<Producto> metodoJPQL(double precioInf, double precioSup) {
        return productoDao.metodoJPQL(precioInf, precioSup);
    }

    
}

