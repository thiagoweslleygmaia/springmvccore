package br.com.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.springmvc.business.DepartamentoBusiness;
import br.com.springmvc.business.DepartamentoBusinessImpl;

@Configuration
@ComponentScan({ "br.com.springmvc" })
@Import(value = { ApplicationConfig.class })
@EnableTransactionManagement
public class ConfigContextCore {
	
	@Bean
	public DepartamentoBusiness departamentoBusiness() {
		return new DepartamentoBusinessImpl();
	}
}