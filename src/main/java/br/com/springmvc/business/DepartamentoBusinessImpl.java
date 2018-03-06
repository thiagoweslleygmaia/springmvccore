package br.com.springmvc.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springmvc.dao.DepartamentoDao;
import br.com.springmvc.model.Departamento;

@Service
//@Component
//@Transactional
public class DepartamentoBusinessImpl implements DepartamentoBusiness {

	@Autowired
	private DepartamentoDao departamentoDao;
	
	public DepartamentoBusinessImpl() {
		super();
	}
	
	public DepartamentoBusinessImpl(DepartamentoDao departamentoDao) {
		this.departamentoDao = departamentoDao;
	}
	
	@Override
	public Departamento buscarDepartamento(Departamento departamento) throws Exception {
		if(departamento==null
				|| departamento.getCodDepartamento()==null){
			throw new Exception("Código departamento é obrigatório.");
		}
		try {
			return departamentoDao.buscarDepartamento(departamento);
		} catch (Exception e) {
			throw new Exception("Erro ao buscar departamento.");
		}
	}

	@Override
	public List<Departamento> listarDepartamentos() throws Exception {
		try {
			return departamentoDao.listarDepartamentos();
		} catch (Exception e) {
			throw new Exception("Erro ao listar departamentos.");
		}
	}

	@Override
	public Departamento incluirDepartamento(Departamento departamento) throws Exception {
		validaDadosDepartamento(departamento);
		try {
			return departamentoDao.incluirDepartamento(departamento);
		} catch (Exception e) {
			throw new Exception("Erro ao incluir departamento.");
		}
	}

	@Override
	public Departamento atualizarDepartamento(Departamento departamento) throws Exception {
		validaDadosDepartamento(departamento);
		try {
			return departamentoDao.atualizarDepartamento(departamento);
		} catch (Exception e) {
			throw new Exception("Erro ao atualizar departamnto.");
		}
	}

	@Override
	public Departamento excluirDepartamento(Departamento departamento) throws Exception {
		if(departamento==null
				|| departamento.getCodDepartamento()==null
				|| departamento.getCodDepartamento()==0){
			throw new Exception("Código departamento é obrigatório.");
		}
		try {
			return departamentoDao.excluirDepartamento(departamento);
		} catch (Exception e) {
			throw new Exception("Erro ao excluir departamnto.");
		}
	}
	
	private void validaDadosDepartamento(Departamento departamento) throws Exception{
		if(departamento==null
				|| departamento.getCodDepartamento()==null
				|| departamento.getCodDepartamento()==0){
			throw new Exception("Código departamento é obrigatório.");
		}
		if(departamento.getNomeDepartamento()==null
				|| departamento.getNomeDepartamento().isEmpty()){
			throw new Exception("Nome departamento é obrigatório.");
		}
	}
	
//	public static void main(String[] args) {
//		try {
//			AbstractApplicationContext context = new AnnotationConfigApplicationContext(configContextCore.class);
//			DepartamentoBusiness departamentoBusiness = (DepartamentoBusiness) context.getBean("departamentoBusinessImpl");
//			List<Departamento> listDepart = departamentoBusiness.listarDepartamentos();
//			for (Departamento dep : listDepart) {
//				System.out.println(dep.getCodDepartamento());
//				System.out.println(dep.getNomeDepartamento());
//				System.out.println(dep.getLocalizacaoDepartamento());
//			}
//			context.close();
//		} catch (Exception e) {
//			Logger.getLogger(DepartamentoBusinessImpl.class).error(e.getMessage());
//		}
//	}
}
