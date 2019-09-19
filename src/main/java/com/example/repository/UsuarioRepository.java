package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dto.Usuario.UsuarioDto;
import com.example.entities.*;
@Repository 

public interface UsuarioRepository extends JpaRepository<Segu_Usuario, Integer>{

	 String queryAll="select new com.example.dto.Usuario.UsuarioDto(t.idUsuario,t.userName) from Segu_Usuario t"
	 		+ " where 1=1";
	 String orderBy=" Order by t.id desc";
	
	 @Query(value=queryAll+orderBy)
	 public List<UsuarioDto> getAll();
	
	 
	 @Query(value=queryAll+" and t.idUsuario=?1"+orderBy)
	 public List<UsuarioDto> getObjById(int id);
	 
	 @Query(value=queryAll+" and t.userName=?1")
	 public List<UsuarioDto> getObjByUserName(String  userName);
	 
}
