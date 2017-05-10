package org.enset.metier;

import org.enset.entities.Compte;

public interface CompteMetier {
	public Compte saveCompte(Compte compte);
	public Compte getCompte(String code);
}
