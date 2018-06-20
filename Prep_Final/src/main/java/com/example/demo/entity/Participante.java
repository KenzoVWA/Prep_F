package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="participante")
public class Participante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@NotNull
	public String name;
	
	@NotNull
	public String tiu;
	
	@NotNull
	public String sede;
	
	@OneToMany(mappedBy="participante", fetch=FetchType.EAGER, orphanRemoval=true, cascade=CascadeType.ALL)
	public List<Resultado> resultados;

	public Participante() {
		resultados=new ArrayList<>();
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public List<Resultado> getResultados() {
		return resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTiu() {
		return tiu;
	}

	public void setTiu(String tiu) {
		this.tiu = tiu;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
