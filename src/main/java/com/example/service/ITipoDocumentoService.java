package com.example.service;
import com.example.dto.TipoDocumentoDto;
import com.example.dto.TipoDocumentoDtoResponse;


//@Service
public interface ITipoDocumentoService {
	
	 public TipoDocumentoDtoResponse save(TipoDocumentoDto obj);
	 public TipoDocumentoDtoResponse getAll();
	 public TipoDocumentoDtoResponse get(int id);
	
}
