package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dto.PerfilDto;
import com.example.entities.*;
@Repository 

public interface PerfilRepository extends JpaRepository<Segu_Perfil, Integer>{

	 String queryAll="select new com.example.dto.PerfilDto(t.idPerfil,t.glosa,t.activo) from Segu_Perfil t"
	 		+ " where 1=1";
	 String orderBy=" Order by t.id desc";
	
	 @Query(value=queryAll+orderBy)
	 public List<PerfilDto> getAll();
	
	 
	 @Query(value=queryAll+" and t.idPerfil=?1"+orderBy)
	 public List<PerfilDto> getObjById(int id);
	 
}
