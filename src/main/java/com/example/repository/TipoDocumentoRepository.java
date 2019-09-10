package com.example.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dto.TipoDocumentoDto;
import com.example.entities.TipoDocumento;
@Repository 
//@EnableJpaRepositories("com.example.dto")

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long>{

	
	

	 String queryAll="select new com.example.dto.TipoDocumentoDto(t.id,t.glosa) from TipoDocumento t"
	 		+ " where 1=1";
	
	 @Query(value=queryAll)
	 public List<TipoDocumentoDto> getAll();
	 
	 
	 @Query(value=queryAll+" and t.id=?1")
	 public List<TipoDocumentoDto> getTipoDocumentoById(int id);
}
