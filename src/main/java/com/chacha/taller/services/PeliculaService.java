package com.chacha.taller.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.taller.models.entities.Pelicula;
import com.chacha.taller.models.dao.IPelicula;

@Service
public class PeliculaService implements IPeliculaService{

	@Autowired
	private IPelicula dao;
	
	@Override
	@Transactional
	public void save(Pelicula pelicula) {
		dao.save(pelicula);
		
	}

	@Transactional
	public Pelicula findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional
	public List<Pelicula> findAll() {
		// TODO Auto-generated method stub
		return (List<Pelicula>) dao.findAll();
	}
}
