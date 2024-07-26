package com.reposteria_patri.dao;

import com.reposteria_patri.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao 
        extends JpaRepository<Categoria, Long> {
    
}
