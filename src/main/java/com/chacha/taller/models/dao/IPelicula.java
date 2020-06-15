package com.chacha.taller.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.chacha.taller.models.entities.Pelicula;

public interface IPelicula extends CrudRepository<Pelicula, Integer> {

}
