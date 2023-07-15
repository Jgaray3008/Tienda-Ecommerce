package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    // Se obtiene un listado de categorias en un List
    public List<Categoria> getCategorias(boolean activos);
        // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Categoria categoria);

    public Categoria getCategoria(Categoria categoria); 
 
}
