package com.tienda.service.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();
        if(activos){
            lista.removeIf(producto -> !producto.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Long id) {
        Optional<Producto> optionalProducto = productoDao.findById(id);
        if(optionalProducto.isPresent()){
            return optionalProducto.get();
        } else {
            throw new RuntimeException("No se encontró el producto con id: " + id);
        }
    }
    @Override
    public List<Producto> findAll() {
        return productoDao.findAll();
    }

    @Override
    public void save(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto findById(Long idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Long idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
