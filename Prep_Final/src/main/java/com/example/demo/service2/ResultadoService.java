package com.example.demo.service2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ResultadoDAO;
import com.example.demo.entity.Resultado;
import com.example.demo.service1.IResultadoService;
@Service
public class ResultadoService implements IResultadoService {

	
	@Autowired
	public ResultadoDAO dao;
	
	@Override
	@Transactional
	public void save(Resultado resultado) {
		// TODO Auto-generated method stub
		if(resultado.getPuesto()==1) {
			resultado.setPuntaje(5);
		}else if(resultado.getPuesto()==2){
			resultado.setPuntaje(3);
		}else if(resultado.getPuesto()==3){
			resultado.setPuntaje(2);
		}else if(resultado.getPuesto()==4){
			resultado.setPuntaje(1);
		}
		
		dao.save(resultado);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Resultado> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Resultado> listEspecial() {
		// TODO Auto-generated method stub
		List<Resultado> aux=new ArrayList<>();
		List<Resultado> aux2=new ArrayList<>();
		aux= dao.findEspecial();
		
		for(int i=0;i<aux.size()-1;i++) {
			
			Resultado res=aux.get(i);
			int suma=res.getPuntaje();
			
			for(int j=i+1;j<aux.size();j++) {
				if(aux.get(i).getParticipante().getName().equalsIgnoreCase(aux.get(j).getParticipante().getName())) {
					suma=suma+aux.get(j).getPuntaje();
				}
			}
			res.setPuntaje(suma);
			boolean flag=false;
			for(int k=0;k<aux2.size();k++) {	
			
			if(aux2.get(k).getParticipante().getName()==res.getParticipante().getName())
				flag=true;
			}
			
			if(flag==false)
				aux2.add(res);
			
		}
		
		return Ordenar(aux2);
	}

	private List<Resultado> Ordenar(List<Resultado> aux) {
		
		int mayor=aux.get(0).getPuntaje();
		for(int i=1;i<aux.size();i++) {
			if(aux.get(i).getPuntaje()>mayor) {
				Resultado auxiliar=aux.get(i-1);
				aux.set(i-1, aux.get(i));
				aux.set(i, auxiliar);
			}
		}
		return aux;
	}


	@Override
	@Transactional(readOnly=true)
	public List<Resultado> listByDia(Long dia) {
		// TODO Auto-generated method stub
		return Ordenar(dao.findByDia(dia));
	}

	@Override
	@Transactional(readOnly=true)
	public List<Resultado> findByFecha(Date fecha) {
		// TODO Auto-generated method stub
		return Ordenar(dao.findByFecha(fecha));
	}

}
