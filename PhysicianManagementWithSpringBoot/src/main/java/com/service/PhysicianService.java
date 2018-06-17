package com.service;

import java.util.Optional;
import com.model.Physician;

public interface PhysicianService {
	
	public Iterable<Physician> getAll();
	
	public String insertUser(int id, String name,String dept);
	
	public Optional<Physician> getUserById(Long id);
	
	public String deleteUserById(Long id);

}