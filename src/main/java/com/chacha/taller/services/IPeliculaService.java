package com.chacha.taller.services;

import java.util.List;

import com.chacha.taller.models.entities.Pelicula;

public interface IPeliculaService {

	public void save(Pelicula pelicula);
	public Pelicula findById(Integer id);
	public void delete(Integer id);
	public List<Pelicula> findAll();
}
