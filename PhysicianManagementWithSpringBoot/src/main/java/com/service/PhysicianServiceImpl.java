package com.service;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controller.RetrievePhysicians;
import com.model.Physician;
import com.repository.PhyRepo;

@Service
public class PhysicianServiceImpl implements PhysicianService {
	
	private static final Log logger = LogFactory.getLog(RetrievePhysicians.class);

	@Autowired
	PhyRepo phyRepo;
	
	@Autowired
	Physician physician;

	@Override
	public Iterable<Physician> getAll() {
		Iterable<Physician> lst = new ArrayList<Physician>();
		lst = phyRepo.findAll();
		return lst;
	}

	@Override
	public String insertUser(int id, String name, String dept) {
		
		physician.setId(id);
		physician.setName(name);
		physician.setDept(dept);
		
		logger.info("File to insert in to DB : "+id+" "+name+" "+dept);
		
		phyRepo.save(physician);
		
		return "User with ID : " + id + " Successfully inserted!!!!!";
	}

	@Override
	public Optional<Physician> getUserById(Long id) {
		Optional<Physician> emp = phyRepo.findById(id);
		return emp;
	}

	@Override
	public String deleteUserById(Long id) {
		phyRepo.deleteById(id);
		return "User with ID : " + id + " Successfully Deleted!!!!!";
	}
}
