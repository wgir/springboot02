package com.example.service;
import com.example.dto.PersonaDto;
import com.example.dto.PersonaDtoResponse;


//@Service
public interface IPersonaService {
	
	 public PersonaDtoResponse save(PersonaDto obj);
	 public PersonaDtoResponse getAll();
	 public PersonaDtoResponse get(Long id);
	 public PersonaDtoResponse update(Long id,PersonaDto obj);
	
}
