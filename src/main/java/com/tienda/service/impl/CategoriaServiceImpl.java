package com.tienda.service.impl;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    @Transactional (readOnly=true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista = categoriaDao.findAll();
        if(activos){
            lista.removeIf(categoriaEletemento -> !categoriaEletemento.isActivo() );
        }
        return lista;        
    }
    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        Optional<Categoria> optionalCategoria = categoriaDao.findById(categoria.getIdCategoria());
        if (optionalCategoria.isPresent()) {
            return optionalCategoria.get();
        } else {
            throw new RuntimeException("No se encontró la categoría con id: " + categoria.getIdCategoria());
        }
    }

}
