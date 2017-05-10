package org.enset.rmi;

import java.rmi.RemoteException;

import org.enset.entities.Compte;
import org.enset.metier.CompteMetier;
import org.enset.metier.OperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myRmiService")
public class BanqueRmiImpl implements BanqueRmiService {
	
	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private OperationMetier operationMetier;

	@Override
	public Compte saveCompte(Compte compte) throws RemoteException {
		// TODO Auto-generated method stub
		return compteMetier.saveCompte(compte);
	}

	@Override
	public Compte getCompte(String code) throws RemoteException {
		// TODO Auto-generated method stub
		return compteMetier.getCompte(code);
	}

	@Override
	public boolean verser(String codeCmpt, double montant, Long codeEmpl) throws RemoteException {
		// TODO Auto-generated method stub
		return operationMetier.verser(codeCmpt, montant, codeEmpl);
	}

	@Override
	public boolean retirer(String codeCmpt, double montant, Long codeEmpl) throws RemoteException {
		// TODO Auto-generated method stub
		return operationMetier.retirer(codeCmpt, montant, codeEmpl);
	}

	@Override
	public boolean virement(String codeCmpt1, String codeCmpt2, double montant, Long codeEmpl) throws RemoteException {
		// TODO Auto-generated method stub
		return operationMetier.virement(codeCmpt1, codeCmpt2, montant, codeEmpl);
	}

}
