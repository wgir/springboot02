package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.dto.ContactoDto;
import com.example.entities.Contacto;
@Repository 
//@EnableJpaRepositories("com.example.dto")

public interface ContactoRepository extends JpaRepository<Contacto, Long>{
	
	 String queryAll="select new com.example.dto.ContactoDto(t.id,t.documento,t.firstName,t.lastName) from Contacto t"
	 		+ " where 1=1";
	
	 @Query(value=queryAll)
	 public List<ContactoDto> getAll();
	 
	 
	 @Query(value=queryAll+" and t.id=?1")
	 public List<ContactoDto> getContactoById(Long id);
	  
}
