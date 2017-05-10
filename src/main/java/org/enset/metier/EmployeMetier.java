package org.enset.metier;

import java.util.List;

import org.enset.entities.Employe;

public interface EmployeMetier {
	public Employe saveEmploye(Employe employe);
	public List<Employe> listEmployes();
	

}
