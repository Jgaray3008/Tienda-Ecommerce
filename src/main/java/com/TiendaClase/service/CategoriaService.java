package com.TiendaClase.service;
import com.TiendaClase.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //SE OBTIENE UN LISTADO DE CATEGORIAS DE UN LIST
    public List<Categoria> getCategorias(boolean activos);

    public List<Categoria> getCategoria(Categoria categoria);
    
    public void save(Categoria categoria);
    
    public void delete(Categoria categoria);


}
