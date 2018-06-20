package br.com.springmvc.departamento.business;

import java.util.List;

import br.com.springmvc.departamento.business.exception.DepartamentoBusinessException;
import br.com.springmvc.model.Departamento;

public interface DepartamentoBusiness {

	Departamento buscarDepartamento(Departamento departamento) throws DepartamentoBusinessException;
	
	List<Departamento> listarDepartamentos() throws DepartamentoBusinessException;
	
	Departamento incluirDepartamento(Departamento departamento) throws DepartamentoBusinessException;
	
	Departamento atualizarDepartamento(Departamento departamento) throws DepartamentoBusinessException;
	
	Departamento excluirDepartamento(Departamento departamento) throws DepartamentoBusinessException;
}
