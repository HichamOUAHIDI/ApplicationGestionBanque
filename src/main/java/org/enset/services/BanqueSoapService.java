package org.enset.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.enset.dao.CompteRepository;
import org.enset.dao.OperationRepository;
import org.enset.entities.Compte;
import org.enset.metier.CompteMetier;
import org.enset.metier.OperationMetier;
import org.enset.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebService
public class BanqueSoapService {
	@Autowired
	private CompteMetier compteMetier;
	
	@WebMethod
	public Compte getCompte(@WebParam(name="code")String code) {
		return compteMetier.getCompte(code);
	}
	
	@WebMethod
	public boolean verser(@WebParam(name="code")String codeCmpt,
			@WebParam(name="montant")double montant,
			@WebParam(name="codeEmpl")Long codeEmpl) {
		return operationMetier.verser(codeCmpt, montant, codeEmpl);
	}
	@WebMethod
	public boolean retirer(@WebParam(name="code")String codeCmpt,
			@WebParam(name="montant")double montant,
			@WebParam(name="codeEmpl")Long codeEmpl) {
		return operationMetier.retirer(codeCmpt, montant, codeEmpl);
	}
	@WebMethod
	public boolean virement(@WebParam(name="code1")String codeCmpt1,
			@WebParam(name="code2")String codeCmpt2,
			@WebParam(name="montant")double montant,
			@WebParam(name="codeEmpl")Long codeEmpl) {
		return operationMetier.virement(codeCmpt1, codeCmpt2, montant, codeEmpl);
	}
	@WebMethod
	public PageOperation getOperations(@WebParam(name="code")String codeCmpt,
			@WebParam(name="page")int page,
			@WebParam(name="size")int size) {
		return operationMetier.getOperations(codeCmpt, page, size);
	}
	@Autowired
	private OperationMetier operationMetier; 
}
