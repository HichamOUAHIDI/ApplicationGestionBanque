package org.enset.metier;

import java.util.Date;

import javax.management.RuntimeErrorException;

import org.enset.dao.CompteRepository;
import org.enset.dao.EmployeRepository;
import org.enset.dao.OperationRepository;
import org.enset.entities.Compte;
import org.enset.entities.Employe;
import org.enset.entities.Operation;
import org.enset.entities.Retrait;
import org.enset.entities.Versment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationMetierImpl implements OperationMetier {
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository OoperationRepository;
	@Autowired
	private EmployeRepository employeRepository;
	@Override
	@Transactional
	public boolean verser(String codeCmpt, double montant, Long codeEmpl) {
		
		Compte compte=compteRepository.findOne(codeCmpt);
		Operation operation=new Versment();
		Employe e=employeRepository.findOne(codeEmpl);
		operation.setDateOperation(new Date());
		operation.setMontant(montant);
		operation.setCompte(compte);
		operation.setEmploye(e);
		OoperationRepository.save(operation);
		compte.setSold(compte.getSold()+montant);
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@Transactional
	public boolean retirer(String codeCmpt, double montant, Long codeEmpl) {
		Compte compte=compteRepository.findOne(codeCmpt);
		Operation operation=new Retrait();
		Employe e=employeRepository.findOne(codeEmpl);
		operation.setDateOperation(new Date());
		operation.setMontant(montant);
		operation.setCompte(compte);
		operation.setEmploye(e);
		OoperationRepository.save(operation);
		if(compte.getSold()<montant) throw new RuntimeException("sold insuffisant");
		compte.setSold(compte.getSold()-montant);
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@Transactional
	public boolean virement(String codeCmpt1, String codeCmpt2, double montant, Long codeEmpl) {
		retirer(codeCmpt1, montant, codeEmpl);
		verser(codeCmpt2, montant, codeEmpl);
		return true;
	}

	@Override
	public PageOperation getOperations(String codeCmpt, int page, int size) {
		// TODO Auto-generated method stub
		Page<Operation> operations=OoperationRepository.getoperations(codeCmpt,new PageRequest(page, size));
		//Page<Operation> operation2=OoperationRepository.findByCompte(compteRepository.findOne(codeCmpt),new PageRequest(page, size))
		PageOperation ops=new PageOperation();
		ops.setOperations(operations.getContent());
		ops.setPage(operations.getNumber());
		ops.setNombreOperation(operations.getNumberOfElements());
		ops.setTotalOperation((int)operations.getTotalPages());
		ops.setTotalPages((int)operations.getTotalPages());
		
		ops.setPage(operations.getNumber());
		return ops;
	}

}
