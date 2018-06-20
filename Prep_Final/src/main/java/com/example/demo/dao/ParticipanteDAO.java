package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Participante;

@Repository
public interface ParticipanteDAO extends JpaRepository<Participante, Long> {

}
