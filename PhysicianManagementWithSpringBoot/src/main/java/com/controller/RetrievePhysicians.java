package com.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.model.Physician;
import com.service.PhysicianServiceImpl;

@RestController
public class RetrievePhysicians {


	@Autowired
	PhysicianServiceImpl physicianService;

	@RequestMapping(value = "/")
	public ModelAndView defaultHomePage() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/getAll")
	public Iterable<Physician> getAll() {

		return physicianService.getAll();
	}

	@RequestMapping("{id}/{name}/{dept}")
	public String insertUser(@PathVariable("id") int id,
			@PathVariable String name, @PathVariable String dept) {

		return physicianService.insertUser(id, name, dept);

	}

	@RequestMapping(value = "/{id}/get")
	public Optional<Physician> getUserById(@PathVariable("id") Long id) {

		return physicianService.getUserById(id);

	}

	@RequestMapping(value = "/{id}/delete")
	public String deleteUserById(@PathVariable("id") Long id) {

		return physicianService.deleteUserById(id);

	}
}
