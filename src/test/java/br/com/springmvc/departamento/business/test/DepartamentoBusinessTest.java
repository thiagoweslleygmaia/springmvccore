package br.com.springmvc.departamento.business.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.springmvc.config.ApplicationConfig;
import br.com.springmvc.departamento.business.DepartamentoBusiness;
import br.com.springmvc.departamento.dao.DepartamentoDao;
import br.com.springmvc.model.Departamento;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@Rollback(value = true)
@Transactional
public class DepartamentoBusinessTest {

	@Mock
	private DepartamentoDao departamentoDao;
	
	@InjectMocks
	@Autowired
	private DepartamentoBusiness departamentoBusiness;
	
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
	
	private Departamento getGenerateDepartamento(){
		Departamento dep = new Departamento();
		dep.setCodDepartamento(1L);
		dep.setNomeDepartamento("FINANCEIRO");
		dep.setLocalizacaoDepartamento("1º ANDAR, SALA 22");
		return dep;
	}
	
	@Test
	public void testSuccessBuscarDepartamento(){
		Departamento dep = getGenerateDepartamento();
		Mockito.when(departamentoDao.buscarDepartamento(dep)).thenReturn(dep);
		try {
			dep = departamentoBusiness.buscarDepartamento(dep);
			Assert.assertEquals(new Long(1), dep.getCodDepartamento());
			Assert.assertEquals("FINANCEIRO", dep.getNomeDepartamento());
			Assert.assertEquals("1º ANDAR, SALA 22", dep.getLocalizacaoDepartamento());
		} catch (Exception e) {
			Assert.fail("Não deveria dispara uma Exception: "+e.getMessage());
		}
	}
	
	@Test
	public void testFailBuscarDepartamentoSemCodDep(){
		Departamento dep = getGenerateDepartamento();
		Mockito.when(departamentoDao.buscarDepartamento(dep)).thenThrow(new RuntimeException("Erro"));
		try {
			departamentoBusiness.buscarDepartamento(dep);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro ao buscar departamento.", e.getMessage());
		}
	}
	
	@Test
	public void testFailBuscarDepartamento(){
		try {
			departamentoBusiness.buscarDepartamento(new Departamento());
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Código departamento é obrigatório.", e.getMessage());
		}
	}
	
	@Test
	public void testSuccessListarDepartamentos(){
		Departamento dep = getGenerateDepartamento();
		List<Departamento> listDepart = new ArrayList<Departamento>();
		listDepart.add(dep);
		Mockito.when(departamentoDao.listarDepartamentos()).thenReturn(listDepart);
		try {
			listDepart = departamentoBusiness.listarDepartamentos();
			Assert.assertEquals(new Long(1), listDepart.get(0).getCodDepartamento());
			Assert.assertEquals("FINANCEIRO", listDepart.get(0).getNomeDepartamento());
			Assert.assertEquals("1º ANDAR, SALA 22", listDepart.get(0).getLocalizacaoDepartamento());
		} catch (Exception e) {
			Assert.fail("Não deveria dispara exception: " + e.getMessage());
		}
	}
	
	@Test
	public void testFailListarDepartamentos(){
		Departamento dep = getGenerateDepartamento();
		List<Departamento> listDepart = new ArrayList<Departamento>();
		listDepart.add(dep);
		Mockito.when(departamentoDao.listarDepartamentos()).thenThrow(new RuntimeException("Erro"));
		try {
			listDepart = departamentoBusiness.listarDepartamentos();
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro ao listar departamentos.", e.getMessage());
		}
	}
	
	@Test
	public void testSuccessIncluirDepartamento(){
		Departamento dep = getGenerateDepartamento();
		Mockito.when(departamentoDao.incluirDepartamento(dep)).thenReturn(dep);
		try {
			dep = departamentoBusiness.incluirDepartamento(dep);
			Assert.assertEquals(new Long(1), dep.getCodDepartamento());
			Assert.assertEquals("FINANCEIRO", dep.getNomeDepartamento());
			Assert.assertEquals("1º ANDAR, SALA 22", dep.getLocalizacaoDepartamento());
		} catch (Exception e) {
			Assert.fail("Não deveria dispara exception: " + e.getMessage());
		}
	}
	
	@Test
	public void testFailIncluirDepartamentoSemCodDep(){
		Departamento dep = getGenerateDepartamento();
		dep.setCodDepartamento(null);
		try {
			departamentoBusiness.incluirDepartamento(dep);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Código departamento é obrigatório.", e.getMessage());
		}
	}
	
	@Test
	public void testFailIncluirDepartamentoSemNomeDep(){
		Departamento dep = getGenerateDepartamento();
		dep.setNomeDepartamento(null);
		try {
			departamentoBusiness.incluirDepartamento(dep);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nome departamento é obrigatório.", e.getMessage());
		}
	}
	
	@Test
	public void testFailIncluirDepartamento(){
		Departamento dep = getGenerateDepartamento();
		Mockito.when(departamentoDao.incluirDepartamento(dep)).thenThrow(new RuntimeException("Erro"));
		try {
			departamentoBusiness.incluirDepartamento(dep);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro ao incluir departamento.", e.getMessage());
		}
	}
	
	@Test
	public void testSuccessAtualizarDepartamento(){
		Departamento dep = getGenerateDepartamento();
		Mockito.when(departamentoDao.atualizarDepartamento(dep)).thenReturn(dep);
		try {
			dep = departamentoBusiness.atualizarDepartamento(dep);
			Assert.assertEquals(new Long(1), dep.getCodDepartamento());
			Assert.assertEquals("FINANCEIRO", dep.getNomeDepartamento());
			Assert.assertEquals("1º ANDAR, SALA 22", dep.getLocalizacaoDepartamento());
		} catch (Exception e) {
			Assert.fail("Não deveria dispara exception: " + e.getMessage());
		}
	}
	
	@Test
	public void testFailAtualizarDepartamentoSemCodDep(){
		Departamento dep = getGenerateDepartamento();
		dep.setCodDepartamento(null);
		try {
			departamentoBusiness.atualizarDepartamento(dep);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Código departamento é obrigatório.", e.getMessage());
		}
	}
	
	@Test
	public void testFailAtualizarDepartamentoSemNomeDep(){
		Departamento dep = getGenerateDepartamento();
		dep.setNomeDepartamento(null);
		try {
			departamentoBusiness.atualizarDepartamento(dep);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nome departamento é obrigatório.", e.getMessage());
		}
	}
	
	@Test
	public void testFailAtualizarDepartamento(){
		Departamento dep = getGenerateDepartamento();
		Mockito.when(departamentoDao.atualizarDepartamento(dep)).thenThrow(new RuntimeException("Erro"));
		try {
			departamentoBusiness.atualizarDepartamento(dep);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro ao atualizar departamnto.", e.getMessage());
		}
	}
	
	@Test
	public void testSuccessExcluirDepartamento(){
		Departamento dep = getGenerateDepartamento();
		Mockito.when(departamentoDao.excluirDepartamento(dep)).thenReturn(dep);
		try {
			dep = departamentoBusiness.excluirDepartamento(dep);
			Assert.assertEquals(new Long(1), dep.getCodDepartamento());
			Assert.assertEquals("FINANCEIRO", dep.getNomeDepartamento());
			Assert.assertEquals("1º ANDAR, SALA 22", dep.getLocalizacaoDepartamento());
		} catch (Exception e) {
			Assert.fail("Não deveria dispara exception: " + e.getMessage());
		}
	}
	
	@Test
	public void testFailExcluirDepartamentoSemCodDep(){
		Departamento dep = getGenerateDepartamento();
		dep.setCodDepartamento(null);
		try {
			departamentoBusiness.excluirDepartamento(dep);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Código departamento é obrigatório.", e.getMessage());
		}
	}
	
	@Test
	public void testFailExcluirDepartamento(){
		Departamento dep = getGenerateDepartamento();
		Mockito.when(departamentoDao.excluirDepartamento(dep)).thenThrow(new RuntimeException("Erro"));
		try {
			departamentoBusiness.excluirDepartamento(dep);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Erro ao excluir departamnto.", e.getMessage());
		}
	}
}
