package com.chacha.taller.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chacha.taller.models.entities.Pelicula;
import com.chacha.taller.services.IPeliculaService;

@Controller
@RequestMapping(value="/pelicula") 
public class PeliculaController {

	
	@Autowired
	private IPeliculaService srvPelicula;
	
	@GetMapping(value="/create")
	  public String create(Model model) {
		  Pelicula pelicula=new Pelicula();
		  model.addAttribute("title", "Registro de nueva Pelicula");
		  model.addAttribute("pelicula",pelicula);
		  return "pelicula/form";
	  }
	  
	  
	  @GetMapping(value="/retrieve/{id}")
	  public String retrieve(@PathVariable(value="id")Integer id,Model model) {
		  Pelicula pelicula=srvPelicula.findById(id);
		  model.addAttribute("pelicula", pelicula);
		  return "pelicula/card";
	  }
	  
	  @GetMapping(value="/update/{id}")
	  public String update(@PathVariable(value="id") Integer id,Model model) {
		  Pelicula pelicula = srvPelicula.findById(id);
		  model.addAttribute("pelicula", pelicula);
		  model.addAttribute("title", "Actualizando el registro de " + pelicula.getNombre());
		  return "pelicula/form";
	  }
	  
	  @GetMapping(value="/delete/{id}")
		public String delete(@PathVariable(value="id") Integer id, Model model, 
				RedirectAttributes flash) {
			try {
				this.srvPelicula.delete(id);
				flash.addFlashAttribute("success", "El registro fue eliminado con éxito.");
			}	
			catch(Exception ex) {
				flash.addFlashAttribute("error", "El registro no pudo ser eliminado.");
			}
			return "redirect:/pelicula/list";		
		} 
	  
	  @GetMapping(value="/list")
		public String list(Model model) {
			List<Pelicula> peliculas = this.srvPelicula.findAll();
			model.addAttribute("peliculas", peliculas);
			model.addAttribute("title", "Listado de Peliculas");
			return "pelicula/list";		
		}
	  
	  @PostMapping(value="/save")
	  public String save(Pelicula pelicula,Model model) {
		  this.srvPelicula.save(pelicula);
		  return "redirect:/pelicula/list";  
	  }
}
