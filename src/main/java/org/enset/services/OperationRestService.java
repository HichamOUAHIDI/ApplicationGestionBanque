package org.enset.services;

import org.enset.metier.OperationMetier;
import org.enset.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationRestService {
	@Autowired
	OperationMetier operationMetier;
	@RequestMapping(value="/operations",method=RequestMethod.GET)
	public PageOperation getOperations(@RequestParam String codeCmpt,@RequestParam int page,@RequestParam int size) {
		return operationMetier.getOperations(codeCmpt, page, size);
	}
	@RequestMapping(value="/verser",method=RequestMethod.GET)
	public boolean verser(@RequestParam String codeCmpt,@RequestParam double montant,@RequestParam Long codeEmpl) {
		return operationMetier.verser(codeCmpt, montant, codeEmpl);
	}
	@RequestMapping(value="/retrait",method=RequestMethod.GET)
	public boolean retirer(@RequestParam String codeCmpt,@RequestParam double montant,@RequestParam Long codeEmpl) {
		return operationMetier.retirer(codeCmpt, montant, codeEmpl);
	}
	@RequestMapping(value="/virement",method=RequestMethod.GET)
	public boolean virement(@RequestParam String codeCmpt1,@RequestParam String codeCmpt2,@RequestParam double montant,@RequestParam Long codeEmpl) {
		return operationMetier.virement(codeCmpt1, codeCmpt2, montant, codeEmpl);
	}

}
