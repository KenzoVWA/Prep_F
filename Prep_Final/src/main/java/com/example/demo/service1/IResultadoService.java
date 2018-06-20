package com.example.demo.service1;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.Resultado;

public interface IResultadoService {

	public void save(Resultado resultado);
	public List<Resultado> findAll();
	public List<Resultado> listEspecial();
	public List<Resultado> listByDia(Long dia);
	public List<Resultado> findByFecha(Date fecha);
	
}
