package org.enset.metier;

public interface OperationMetier {
	
	public boolean verser(String codeCmpt,double montant,Long codeEmpl);
	public boolean retirer(String codeCmpt,double montant,Long codeEmpl);
	public boolean virement(String codeCmpt1,String codeCmpt2,double montant,Long codeEmpl);
	public PageOperation getOperations(String codeCmpt,int page,int size);
	
}
