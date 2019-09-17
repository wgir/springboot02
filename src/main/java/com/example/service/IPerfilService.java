package com.example.service;
import com.example.dto.PerfilDto;
import com.example.dto.PerfilDtoResponse;


public interface IPerfilService {
	
	 public PerfilDtoResponse save(PerfilDto obj);
	 public PerfilDtoResponse getAll();
	 public PerfilDtoResponse getById(int id);
	 public PerfilDtoResponse update(int id,PerfilDto obj);

}
