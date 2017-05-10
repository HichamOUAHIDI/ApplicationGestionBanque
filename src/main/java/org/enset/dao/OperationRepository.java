package org.enset.dao;

import org.enset.entities.Compte;
import org.enset.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation, Long> {
	@Query("select o from Operation o where o.compte.codeCompte= :x")
	public Page<Operation> getoperations(@Param("x") String codeCmpt,Pageable pageable);
	public Page<Operation> findByCompte(Compte cpt,Pageable pageable);
}
