package br.com.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.springmvc.business.DepartamentoBusiness;
import br.com.springmvc.business.DepartamentoBusinessImpl;
import br.com.springmvc.dao.DepartamentoDao;

@Configuration
@EnableTransactionManagement
@Import(value = { ApplicationConfig.class })
@ComponentScan({ "br.com.springmvc" })
public class ConfigContextCore {
	
	@Autowired
	private DepartamentoDao departamentoDao;
	
	@Bean
	public DepartamentoBusiness departamentoBusiness() {
		return new DepartamentoBusinessImpl(departamentoDao);
	}
}