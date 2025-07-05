package com.prototipo.p1.repository.primaryDataSource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototipo.p1.model.primary.Maquina;

@Repository
public interface MaquinasRepository extends JpaRepository<Maquina, String>{
    
}
