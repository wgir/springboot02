package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dto.*;
import com.example.entities.*;
@Repository 

public interface UsuarioRepository extends JpaRepository<Segu_Usuario, Integer>{

	 String queryAll="select new com.example.dto.UsuarioDto(t.idPerfil,t.glosa,t.activo) from Segu_Usuario t"
	 		+ " where 1=1";
	 String orderBy=" Order by t.id desc";
	
	 @Query(value=queryAll+orderBy)
	 public List<UsuarioDto> getAll();
	
	 
	 @Query(value=queryAll+" and t.idPerfil=?1"+orderBy)
	 public List<UsuarioDto> getObjById(int id);
	 
	 @Query(value=queryAll+" and t.username=?1")
	 public List<UsuarioDto> getObjByUserNAme(String  userName);
	 
}
