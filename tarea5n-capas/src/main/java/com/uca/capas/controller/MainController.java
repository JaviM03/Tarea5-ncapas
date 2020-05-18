package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;

@Controller
public class MainController {
	@Autowired
	private EstudianteDAO estudianteDAO;
	
	@RequestMapping("/listado")
	public ModelAndView initMain() {
		ModelAndView mav=new ModelAndView();
		List<Estudiante> estudiantes= null;
		try {
			estudiantes = estudianteDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("listado");
		return mav;
	}
	
	@RequestMapping("/index")
	public ModelAndView guardarEstudiante(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		

		if(result.hasErrors()) {
			mav.setViewName("index");
		} else {
		//Mando a llamar al servicio encargado de guardar a la entidad
		mav.addObject("nombre", estudiante.getNombre());
		mav.addObject("apellido", estudiante.getApellido());
		mav.addObject("carne", estudiante.getCarne());
		mav.addObject("carrera", estudiante.getCarrera());
		estudianteDAO.insert(estudiante);

		mav.setViewName("index");
		}
		return mav;
	}

}
