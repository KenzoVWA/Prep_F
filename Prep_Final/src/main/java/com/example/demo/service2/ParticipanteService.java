package com.example.demo.service2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ParticipanteDAO;
import com.example.demo.entity.Participante;
import com.example.demo.service1.IParticipanteService;

@Service
public class ParticipanteService implements IParticipanteService {

	@Autowired
	public ParticipanteDAO dao;
	
	@Override
	@Transactional
	public void save(Participante participante) {
		// TODO Auto-generated method stub
		dao.save(participante);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Participante> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Participante findbyID(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

}
