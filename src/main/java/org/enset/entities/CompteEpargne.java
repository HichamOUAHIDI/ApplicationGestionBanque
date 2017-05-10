package org.enset.entities;

import java.util.Date;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

@Entity
@DiscriminatorValue("CE")
@XmlType(name="CE")
public class CompteEpargne extends Compte {

	private double taux;

	public CompteEpargne() {
		super();
	}

	public CompteEpargne(String codeCompte, Date dateCreation, double sold, double taux) {
		super(codeCompte, dateCreation, sold);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
}
