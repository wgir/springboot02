package com.example.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.dto.PersonaDto;
import com.example.entities.Persona;
@Repository 

public interface PersonaRepository extends JpaRepository<Persona, Long>{
	
	String queryAll="select new com.example.dto.PersonaDto(p.id,p.documento," + 
	 		"p.nombres,p.apellidos,p.sexo,p.email,p.fechaNacimiento)" + 
	 		" from   Persona p where 1=1";
	String orderBy=" Order by p.id desc";
	
	 @Query(value=queryAll+orderBy)
	 public List<PersonaDto> getAll();
	 
	 @Query(value=queryAll+" and p.id=?1"+orderBy)
	 public List<PersonaDto> getPersonaById(Long id);
	 
	
}
