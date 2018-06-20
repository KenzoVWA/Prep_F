package com.example.demo.service1;

import java.util.List;

import com.example.demo.entity.Participante;

public interface IParticipanteService {

	public void save(Participante participante);
	public List<Participante> findAll();
	public Participante findbyID(Long id);
}
