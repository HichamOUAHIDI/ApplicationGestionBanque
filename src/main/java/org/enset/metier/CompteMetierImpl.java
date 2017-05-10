package org.enset.metier;

import org.enset.dao.CompteRepository;
import org.enset.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteMetierImpl implements CompteMetier {
	@Autowired
	private CompteRepository compteRepository;
	@Override
	public Compte saveCompte(Compte compte) {
		// TODO Auto-generated method stub
		return compteRepository.save(compte);
	}
	@Override
	public Compte getCompte(String code) {
		// TODO Auto-generated method stub
		return compteRepository.findOne(code);
	}

}
