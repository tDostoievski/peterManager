package com.prototipo.p1.repository.secundaryDataSource;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prototipo.p1.model.secondary.ProdutoExterno;

public interface ProdutoExternoRepository extends JpaRepository<ProdutoExterno, Integer>{

}
