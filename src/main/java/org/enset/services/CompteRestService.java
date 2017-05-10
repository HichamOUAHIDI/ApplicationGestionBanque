package org.enset.services;

import org.enset.entities.Compte;
import org.enset.metier.CompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompteRestService {
	@Autowired
	private CompteMetier compteMetier;
	
	@RequestMapping(value="/saveCompte",method=RequestMethod.POST)
	public Compte saveCompte(@RequestBody Compte compte) {
		return compteMetier.saveCompte(compte);
	}
	@RequestMapping(value="/comptes/{code}",method=RequestMethod.GET)
	@ResponseBody
	public Compte getCompte(@PathVariable String code) {
		return compteMetier.getCompte(code);
	}
	
}
