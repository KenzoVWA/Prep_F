package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Resultado;

@Repository
public interface ResultadoDAO extends JpaRepository<Resultado, Long> {

	@Query("Select a from Resultado a join fetch a.participante aa")
	public List<Resultado> findEspecial();
	
	@Query("select a from Resultado a where a.dia=?1")
	public List<Resultado> findByDia(Long dia);
	
	@Query("select a from Resultado a where a.createAt=?1")
	public List<Resultado> findByFecha(Date fecha);
	
}
