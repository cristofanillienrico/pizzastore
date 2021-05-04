package it.prova.pizzastore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.prova.pizzastore.web.servlet.auth.LoginServlet;
import it.prova.pizzastore.web.servlet.registration.ExecuteIscrivitiServlet;
import it.prova.pizzastore.web.servlet.registration.PrepareIscrivitiServlet;
import it.prova.pizzastore.web.servlet.utente.PrepareSearchUtenteServlet;

@Configuration
public class SerlvetRegistrationConfig {
	// N.B. se le servlet usano bean al loro interno vanno affidate a spring
	// altrimenti va bene @WebServlet

	@Autowired
	private LoginServlet loginServlet;
	@Autowired
	private PrepareIscrivitiServlet prepareIscrivitiServlet;
	@Autowired
	private ExecuteIscrivitiServlet executeIscrivitiServlet;

//	@Autowired
//	private ExecuteSearchRegistaServlet executeSearchRegistaServlet;
//	@Autowired
//	private ExecuteInsertRegistaServlet executeInsertRegistaServlet;
//	@Autowired
//	private ExecuteListRegistaServlet executeListRegistaServlet;
//	@Autowired
//	private PrepareSearchFilmServlet prepareSearchFilmServlet;
//	@Autowired
//	private PrepareInsertFilmServlet prepareInsertFilmServlet;
//	@Autowired
//	private ExecuteInsertFilmServlet executeInsertFilmServlet;
//	@Autowired
//	private ExecuteListFilmServlet executeListFilmServlet;
//	@Autowired
//	private ExecuteSearchFilmServlet executeSearchFilmServlet;
//	@Autowired
//	private ExecuteVisualizzaRegistaServlet executeVisualizzaRegistaServlet;
//	@Autowired
//	private PrepareRimuoviRegistaServlet prepareRimuoviRegistaServlet;
//	@Autowired
//	private ExecuteRimuoviRegistaServlet executeRimuoviRegistaServlet;
//	@Autowired
//	private PrepareEditRegistaServlet prepareEditRegistaServlet;
//	@Autowired
//	private ExecuteEditRegistaServlet executeEditRegistaServlet;
//	@Autowired
//	private PrepareRimuoviFilmServlet prepareRimuoviFilmServlet;
//	@Autowired
//	private ExecuteRimuoviFilmServlet executeRimuoviFilmServlet;
//	@Autowired
//	private ExecuteVisualizzaFilmServlet executeVisualizzaFilmServlet;
//	@Autowired
//	private PrepareEditFilmServlet prepareEditFilmServlet;
//	@Autowired
//	private ExecuteEditFilmServlet executeEditFilmServlet;
	@Autowired
	private PrepareSearchUtenteServlet prepareSearchUtenteServlet;
//
	@Bean
	public ServletRegistrationBean<LoginServlet> createLoginServletBean() {
		ServletRegistrationBean<LoginServlet> bean = new ServletRegistrationBean<LoginServlet>(loginServlet,
				"/LoginServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<PrepareIscrivitiServlet> createPrepareIscrivitiServletBean() {
		ServletRegistrationBean<PrepareIscrivitiServlet> bean = new ServletRegistrationBean<PrepareIscrivitiServlet>(
				prepareIscrivitiServlet, "/registration/PrepareIscrivitiServlet");
		return bean;
	}
	
	@Bean
	public ServletRegistrationBean<ExecuteIscrivitiServlet> createExecuteIscrivitiServletBean() {
		ServletRegistrationBean<ExecuteIscrivitiServlet> bean = new ServletRegistrationBean<ExecuteIscrivitiServlet>(
				executeIscrivitiServlet, "/registration/ExecuteIscrivitiServlet");
		return bean;
	}
//
//	@Bean
//	public ServletRegistrationBean<ExecuteSearchRegistaServlet> createExecuteSearchRegistaServletBean() {
//		ServletRegistrationBean<ExecuteSearchRegistaServlet> bean = new ServletRegistrationBean<ExecuteSearchRegistaServlet>(
//				executeSearchRegistaServlet, "/ExecuteSearchRegistaServlet");
//		return bean;
//	}
//
//	@Bean
//	public ServletRegistrationBean<ExecuteInsertRegistaServlet> createExecuteInsertRegistaServletBean() {
//		ServletRegistrationBean<ExecuteInsertRegistaServlet> bean = new ServletRegistrationBean<ExecuteInsertRegistaServlet>(
//				executeInsertRegistaServlet, "/ExecuteInsertRegistaServlet");
//		return bean;
//	}
//
//	@Bean
//	public ServletRegistrationBean<ExecuteListRegistaServlet> createExecuteListRegistaServletBean() {
//		ServletRegistrationBean<ExecuteListRegistaServlet> bean = new ServletRegistrationBean<ExecuteListRegistaServlet>(
//				executeListRegistaServlet, "/ExecuteListRegistaServlet");
//		return bean;
//	}
//
//	@Bean
//	public ServletRegistrationBean<PrepareSearchFilmServlet> createPrepareSearchFilmServletBean() {
//		ServletRegistrationBean<PrepareSearchFilmServlet> bean = new ServletRegistrationBean<PrepareSearchFilmServlet>(
//				prepareSearchFilmServlet, "/PrepareSearchFilmServlet");
//		return bean;
//	}
//
//	@Bean
//	public ServletRegistrationBean<PrepareInsertFilmServlet> createPrepareInsertFilmServletBean() {
//		ServletRegistrationBean<PrepareInsertFilmServlet> bean = new ServletRegistrationBean<PrepareInsertFilmServlet>(
//				prepareInsertFilmServlet, "/PrepareInsertFilmServlet");
//		return bean;
//	}
//
//	@Bean
//	public ServletRegistrationBean<ExecuteInsertFilmServlet> createExecuteInsertFilmServletBean() {
//		ServletRegistrationBean<ExecuteInsertFilmServlet> bean = new ServletRegistrationBean<ExecuteInsertFilmServlet>(
//				executeInsertFilmServlet, "/ExecuteInsertFilmServlet");
//		return bean;
//	}
//
//	@Bean
//	public ServletRegistrationBean<ExecuteListFilmServlet> createExecuteListFilmServletBean() {
//		ServletRegistrationBean<ExecuteListFilmServlet> bean = new ServletRegistrationBean<ExecuteListFilmServlet>(
//				executeListFilmServlet, "/ExecuteListFilmServlet");
//		return bean;
//	}
//
//	@Bean
//	public ServletRegistrationBean<ExecuteSearchFilmServlet> createExecuteSearchFilmServletBean() {
//		ServletRegistrationBean<ExecuteSearchFilmServlet> bean = new ServletRegistrationBean<ExecuteSearchFilmServlet>(
//				executeSearchFilmServlet, "/ExecuteSearchFilmServlet");
//		return bean;
//	}
//
//	@Bean
//	public ServletRegistrationBean<ExecuteVisualizzaRegistaServlet> createExecuteVisualizzaRegistaServletBean() {
//		ServletRegistrationBean<ExecuteVisualizzaRegistaServlet> bean = new ServletRegistrationBean<ExecuteVisualizzaRegistaServlet>(
//				executeVisualizzaRegistaServlet, "/ExecuteVisualizzaRegistaServlet");
//		return bean;
//	}
//
//	@Bean
//	public ServletRegistrationBean<PrepareRimuoviRegistaServlet> createPrepareRimuoviRegistaServletBean() {
//		ServletRegistrationBean<PrepareRimuoviRegistaServlet> bean = new ServletRegistrationBean<PrepareRimuoviRegistaServlet>(
//				prepareRimuoviRegistaServlet, "/PrepareRimuoviRegistaServlet");
//		return bean;
//	}
//
//	@Bean
//	public ServletRegistrationBean<ExecuteRimuoviRegistaServlet> createExecuteRimuoviRegistaServletBean() {
//		ServletRegistrationBean<ExecuteRimuoviRegistaServlet> bean = new ServletRegistrationBean<ExecuteRimuoviRegistaServlet>(
//				executeRimuoviRegistaServlet, "/ExecuteRimuoviRegistaServlet");
//		return bean;
//	}
//
//	@Bean
//	public ServletRegistrationBean<PrepareEditRegistaServlet> createPrepareEditRegistaServletBean() {
//		ServletRegistrationBean<PrepareEditRegistaServlet> bean = new ServletRegistrationBean<PrepareEditRegistaServlet>(
//				prepareEditRegistaServlet, "/PrepareEditRegistaServlet");
//		return bean;
//	}
//
//	@Bean
//	public ServletRegistrationBean<ExecuteEditRegistaServlet> createExecuteEditRegistaServletBean() {
//		ServletRegistrationBean<ExecuteEditRegistaServlet> bean = new ServletRegistrationBean<ExecuteEditRegistaServlet>(
//				executeEditRegistaServlet, "/ExecuteEditRegistaServlet");
//		return bean;
//	}
//
//	@Bean
//	public ServletRegistrationBean<PrepareRimuoviFilmServlet> createPrepareRimuoviFilmServletBean() {
//		ServletRegistrationBean<PrepareRimuoviFilmServlet> bean = new ServletRegistrationBean<PrepareRimuoviFilmServlet>(
//				prepareRimuoviFilmServlet, "/PrepareRimuoviFilmServlet");
//		return bean;
//	}
//
//	@Bean
//	public ServletRegistrationBean<ExecuteRimuoviFilmServlet> createExecuteRimuoviFilmServletBean() {
//		ServletRegistrationBean<ExecuteRimuoviFilmServlet> bean = new ServletRegistrationBean<ExecuteRimuoviFilmServlet>(
//				executeRimuoviFilmServlet, "/ExecuteRimuoviFilmServlet");
//		return bean;
//	}
//
//	@Bean
//	public ServletRegistrationBean<ExecuteVisualizzaFilmServlet> createExecuteVisualizzaFilmServletBean() {
//		ServletRegistrationBean<ExecuteVisualizzaFilmServlet> bean = new ServletRegistrationBean<ExecuteVisualizzaFilmServlet>(
//				executeVisualizzaFilmServlet, "/ExecuteVisualizzaFilmServlet");
//		return bean;
//	}
//
//	@Bean
//	public ServletRegistrationBean<PrepareEditFilmServlet> createPrepareEditFilmServletBean() {
//		ServletRegistrationBean<PrepareEditFilmServlet> bean = new ServletRegistrationBean<PrepareEditFilmServlet>(
//				prepareEditFilmServlet, "/PrepareEditFilmServlet");
//		return bean;
//	}
//
//	@Bean
//	public ServletRegistrationBean<ExecuteEditFilmServlet> createExecuteEditFilmServletBean() {
//		ServletRegistrationBean<ExecuteEditFilmServlet> bean = new ServletRegistrationBean<ExecuteEditFilmServlet>(
//				executeEditFilmServlet, "/ExecuteEditFilmServlet");
//		return bean;
//	}
//	
	@Bean
	public ServletRegistrationBean<PrepareSearchUtenteServlet> createPrepareSearchUtenteServletBean() {
		ServletRegistrationBean<PrepareSearchUtenteServlet> bean = new ServletRegistrationBean<PrepareSearchUtenteServlet>(
				prepareSearchUtenteServlet, "/utente/PrepareSearchUtenteServlet");
		return bean;
	}

}
