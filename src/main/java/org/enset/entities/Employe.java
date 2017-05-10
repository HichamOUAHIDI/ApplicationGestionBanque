package org.enset.entities;

import java.io.Serializable;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


@Entity
public class Employe implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeEmploye;
	private String nom;
	@ManyToOne
	@JoinColumn(name="code_emp_sup")
	private Employe employeSup;
	@ManyToMany
	@JoinTable(name="EMP_GR")
	private Collection<Groupe> groupes;
	public Employe() {
		super();
	}
	public Employe(String nom) {
		super();
		this.nom = nom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@JsonIgnore
	@XmlTransient
	public Employe getEmployeSup() {
		return employeSup;
	}
	@JsonSetter
	public void setEmployeSup(Employe employeSup) {
		this.employeSup = employeSup;
	}
	@JsonIgnore
	@XmlTransient
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	@JsonSetter
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	public Long getCodeEmploye() {
		return codeEmploye;
	}
	
	
	
}
