package br.com.froli.springmvc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.froli.springmvc.dao.ContatoDAO;
import br.com.froli.springmvc.dao.ContatoDAOImpl;

@Configuration
@ComponentScan(basePackages = "br.com.froli.springmvc")
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	//@Override
	//public void addResourceHandlers(ResourceHandlerRegistry registry) {
	//	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	//}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://192.168.0.30:3306/spring_mvc_crud_example");
		dataSource.setUsername("root");
		dataSource.setPassword("m010409");
        
        return dataSource;
	}
	
	@Bean
	public ContatoDAO getContatoDAO(DataSource dataSource) {
		return new ContatoDAOImpl(dataSource);
	}
}
