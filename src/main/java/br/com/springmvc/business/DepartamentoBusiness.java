package br.com.springmvc.business;

import java.util.List;

import br.com.springmvc.model.Departamento;

public interface DepartamentoBusiness {

	Departamento buscarDepartamento(Departamento departamento) throws Exception;
	
	List<Departamento> listarDepartamentos() throws Exception;
	
	Departamento incluirDepartamento(Departamento departamento) throws Exception;
	
	Departamento atualizarDepartamento(Departamento departamento) throws Exception;
	
	Departamento excluirDepartamento(Departamento departamento) throws Exception;
}
