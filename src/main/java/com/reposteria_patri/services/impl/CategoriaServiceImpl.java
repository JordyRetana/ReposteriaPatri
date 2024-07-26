package com.reposteria_patri.services.impl;

import com.reposteria_patri.dao.CategoriaDao;
import com.reposteria_patri.domain.Categoria;
import com.reposteria_patri.services.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl 
        implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias() {
        var lista = categoriaDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Categoria getCategorias(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }
    
}
