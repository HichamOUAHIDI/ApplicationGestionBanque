package org.enset.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.enset.entities.Compte;

public interface BanqueRmiService extends Remote {
	
	public Compte saveCompte(Compte compte) throws RemoteException;
	public Compte getCompte(String code) throws RemoteException;
	
	public boolean verser(String codeCmpt,double montant,Long codeEmpl) throws RemoteException;
	public boolean retirer(String codeCmpt,double montant,Long codeEmpl) throws RemoteException;
	public boolean virement(String codeCmpt1,String codeCmpt2,double montant,Long codeEmpl) throws RemoteException;
	

}
