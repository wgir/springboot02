package com.example.service;
import com.example.dto.*;
import com.example.dto.Usuario.*;


public interface UsuarioService {
	
	 public UsuarioDtoResponse save(UsuarioDto obj);
	 public UsuarioDtoResponse getAll();
	 public UsuarioDtoResponse getById(int id);
	 public UsuarioDtoResponse getByUserName(String userName);
	 public UsuarioDtoResponse update(int id,UsuarioDto obj);

	 public Respuesta registrarAdministrador(UsuarioDtoRegistro obj);
}
