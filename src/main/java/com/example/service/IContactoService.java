package com.example.service;
import com.example.dto.ContactoDto;
import com.example.dto.ContactoDtoResponse;


public interface IContactoService {
	
	 public ContactoDtoResponse save(ContactoDto contact);
	 public ContactoDtoResponse getAll();
	 public ContactoDtoResponse get(Long id);
	 public ContactoDtoResponse update(Long id,ContactoDto obj);

}
