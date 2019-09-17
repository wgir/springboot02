package com.example.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.eclipse.persistence.annotations.Customizer;

import com.example.config.ColumnPosition;
import com.example.config.EntityColumnPositionCustomizer;

@MappedSuperclass
@Customizer(EntityColumnPositionCustomizer.class)
public class _BaseEntity {
	
	
	
	
	@Column(name = "createdby")
	@ColumnPosition(position = 30)
	private int createdby;
   
	@Column(name = "createdon")
	@ColumnPosition(position = 31)
    private Calendar createdOn;
   	
   	@Column(name = "editedby")
   	@ColumnPosition(position = 32)
	private int editedBy;
   	
   	@Column(name = "editedon")
   	@ColumnPosition(position = 33)
    private Calendar editedOn;
    
   	
   	@Column(name = "activo")
   	@ColumnPosition(position = 34)
    private boolean  activo;
   	
   	private String ip;
   
	
   
	
	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	
	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}
	
	
	public int getEditedBy() {
		return editedBy;
	}

	public void setEditedBy(int editedBy) {
		this.editedBy = editedBy;
	}

	
	public Calendar getEditedOn() {
		return editedOn;
	}

	public void setEditedOn(Calendar editedOn) {
		this.editedOn = editedOn;
	}
	
	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
}