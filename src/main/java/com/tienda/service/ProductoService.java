package com.tienda.service;

import com.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {
    public List<Producto> getProductos(boolean activos);
    public void delete(Producto producto);
    public Producto getProducto(Long id);

    public List<Producto> findAll();

    public void save(Producto producto);

    public Producto findById(Long idProducto);

    public void deleteById(Long idProducto);
}
