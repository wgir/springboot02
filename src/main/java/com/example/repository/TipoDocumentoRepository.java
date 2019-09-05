package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Contacto;
import com.example.entities.TipoDocumento;
@Repository 
@EnableJpaRepositories("com.example.dto")

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long>{

}
