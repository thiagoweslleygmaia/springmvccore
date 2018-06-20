package br.com.springmvc.departamento.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.springmvc.departamento.business.exception.DepartamentoBusinessException;
import br.com.springmvc.departamento.dao.DepartamentoDao;
import br.com.springmvc.model.Departamento;

@Service
@Transactional(readOnly = true)
public class DepartamentoBusinessImpl implements DepartamentoBusiness {

	@Autowired
	private DepartamentoDao departamentoDao;
	
	@Override
	public Departamento buscarDepartamento(Departamento departamento) throws DepartamentoBusinessException {
		if(departamento==null
				|| departamento.getCodDepartamento()==null){
			throw new DepartamentoBusinessException("Código departamento é obrigatório.");
		}
		try {
			return departamentoDao.buscarDepartamento(departamento);
		} catch (Exception e) {
			throw new DepartamentoBusinessException("Erro ao buscar departamento.");
		}
	}

	@Override
	public List<Departamento> listarDepartamentos() throws DepartamentoBusinessException {
		try {
			return departamentoDao.listarDepartamentos();
		} catch (Exception e) {
			throw new DepartamentoBusinessException("Erro ao listar departamentos.");
		}
	}
	
	@Override
	public Departamento incluirDepartamento(Departamento departamento) throws DepartamentoBusinessException {		
		if(departamento==null
				|| departamento.getNomeDepartamento()==null
				|| departamento.getNomeDepartamento().isEmpty()){
			throw new DepartamentoBusinessException("Nome departamento é obrigatório.");
		}
		try {
			return departamentoDao.incluirDepartamento(departamento);
		} catch (Exception e) {
			throw new DepartamentoBusinessException("Erro ao incluir departamento.");
		}
	}

	@Override
	public Departamento atualizarDepartamento(Departamento departamento) throws DepartamentoBusinessException {
		if(departamento==null
				|| departamento.getCodDepartamento()==null
				|| departamento.getCodDepartamento()==0){
			throw new DepartamentoBusinessException("Código departamento é obrigatório.");
		}
		if(departamento.getNomeDepartamento()==null
				|| departamento.getNomeDepartamento().isEmpty()){
			throw new DepartamentoBusinessException("Nome departamento é obrigatório.");
		}
		try {
			return departamentoDao.atualizarDepartamento(departamento);
		} catch (Exception e) {
			throw new DepartamentoBusinessException("Erro ao atualizar departamnto.");
		}
	}

	@Override
	public Departamento excluirDepartamento(Departamento departamento) throws DepartamentoBusinessException {
		if(departamento==null
				|| departamento.getCodDepartamento()==null
				|| departamento.getCodDepartamento()==0){
			throw new DepartamentoBusinessException("Código departamento é obrigatório.");
		}
		try {
			return departamentoDao.excluirDepartamento(departamento);
		} catch (Exception e) {
			throw new DepartamentoBusinessException("Erro ao excluir departamnto.");
		}
	}		
}
