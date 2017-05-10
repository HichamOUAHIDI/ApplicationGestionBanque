package org.enset.metier;

import java.util.List;

import org.enset.dao.EmployeRepository;
import org.enset.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeMetierImpl implements EmployeMetier {
	@Autowired
	EmployeRepository employeRepository;
	@Override
	public Employe saveEmploye(Employe employe) {
		// TODO Auto-generated method stub
		return employeRepository.save(employe);
	}

	@Override
	public List<Employe> listEmployes() {
		// TODO Auto-generated method stub
		return employeRepository.findAll();
	}
	

}
