package com.example.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.example.dto.PersonaDto;
import com.example.entities.Persona;
@Repository 
//@EnableJpaRepositories("com.example.dto")

public interface PersonaRepository extends JpaRepository<Persona, Long>{
	
	String queryAll="select new com.example.dto.PersonaDto(p.id,p.documento," + 
	 		"p.nombres,p.apellidos,p.sexo,p.email,p.fechaNacimiento)" + 
	 		" from   Persona p where 1=1";
	
	 @Query(value=queryAll)
	 public List<PersonaDto> getAll();
	 
	 @Query(value=queryAll+" and p.id=?1")
	 public List<PersonaDto> getPersonaById(Long id);
	 
	
}
