package org.enset.metier;

import java.io.Serializable;
import java.util.List;

import org.enset.entities.Operation;

public class PageOperation  implements Serializable{
	private List<Operation> operations;
	private int page;
	private int totalPages;
	private int nombreOperation;
	private int totalOperation;
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNombreOperation() {
		return nombreOperation;
	}
	public void setNombreOperation(int nombreOperation) {
		this.nombreOperation = nombreOperation;
	}
	public int getTotalOperation() {
		return totalOperation;
	}
	public void setTotalOperation(int totalOperation) {
		this.totalOperation = totalOperation;
	}
	public PageOperation() {
		super();
	}
	public PageOperation(List<Operation> operations, int page, int nombreOperation, int totalOperation) {
		super();
		this.operations = operations;
		this.page = page;
		this.nombreOperation = nombreOperation;
		this.totalOperation = totalOperation;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	

}
