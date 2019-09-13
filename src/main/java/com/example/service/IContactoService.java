package com.example.service;
import com.example.dto.ContactoDto;
import com.example.dto.ContactoDtoResponse;
import com.example.dto.PersonaDto;
import com.example.dto.PersonaDtoResponse;


//@Service
public interface IContactoService {
	
	 public ContactoDtoResponse save(ContactoDto contact);
	 public ContactoDtoResponse getAll();
	 public ContactoDtoResponse get(Long id);
	 public ContactoDtoResponse update(Long id,ContactoDto obj);

}
