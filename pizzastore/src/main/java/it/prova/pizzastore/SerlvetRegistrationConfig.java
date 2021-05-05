package it.prova.pizzastore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.prova.pizzastore.web.servlet.auth.LoginServlet;
import it.prova.pizzastore.web.servlet.registration.ExecuteIscrivitiServlet;
import it.prova.pizzastore.web.servlet.registration.PrepareIscrivitiServlet;
import it.prova.pizzastore.web.servlet.utente.ExecuteCambiaStatoUtenteServlet;
import it.prova.pizzastore.web.servlet.utente.ExecuteInsertUtenteServlet;
import it.prova.pizzastore.web.servlet.utente.ExecuteListUtenteServlet;
import it.prova.pizzastore.web.servlet.utente.ExecuteSearchUtenteServlet;
import it.prova.pizzastore.web.servlet.utente.ExecuteVisualizzaUtenteServlet;
import it.prova.pizzastore.web.servlet.utente.PrepareCambiaStatoUtenteServlet;
import it.prova.pizzastore.web.servlet.utente.PrepareInsertUtenteServlet;
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
	@Autowired
	private ExecuteVisualizzaUtenteServlet executeVisualizzaUtenteServlet;

	@Autowired
	private PrepareSearchUtenteServlet prepareSearchUtenteServlet;
	@Autowired
	private ExecuteSearchUtenteServlet executeSearchUtenteServlet;
	@Autowired
	private ExecuteListUtenteServlet executeListUtenteServlet;
	@Autowired
	private PrepareCambiaStatoUtenteServlet prepareCambiaStatoUtenteServlet;
	@Autowired
	private ExecuteCambiaStatoUtenteServlet executeCambiaStatoUtenteServlet;

	@Autowired
	private PrepareInsertUtenteServlet prepareInsertUtenteServlet;

	@Autowired
	private ExecuteInsertUtenteServlet executeInsertUtenteServlet;

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

	@Bean
	public ServletRegistrationBean<PrepareSearchUtenteServlet> createPrepareSearchUtenteServletBean() {
		ServletRegistrationBean<PrepareSearchUtenteServlet> bean = new ServletRegistrationBean<PrepareSearchUtenteServlet>(
				prepareSearchUtenteServlet, "/utente/PrepareSearchUtenteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteSearchUtenteServlet> createExecuteSearchUtenteServletBean() {
		ServletRegistrationBean<ExecuteSearchUtenteServlet> bean = new ServletRegistrationBean<ExecuteSearchUtenteServlet>(
				executeSearchUtenteServlet, "/utente/ExecuteSearchUtenteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteVisualizzaUtenteServlet> createExecuteVisualizzaUtenteServletBean() {
		ServletRegistrationBean<ExecuteVisualizzaUtenteServlet> bean = new ServletRegistrationBean<ExecuteVisualizzaUtenteServlet>(
				executeVisualizzaUtenteServlet, "/utente/ExecuteVisualizzaUtenteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteListUtenteServlet> createExecuteListUtenteServletBean() {
		ServletRegistrationBean<ExecuteListUtenteServlet> bean = new ServletRegistrationBean<ExecuteListUtenteServlet>(
				executeListUtenteServlet, "/utente/ExecuteListUtenteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<PrepareCambiaStatoUtenteServlet> createPrepareCambiaStatoUtenteServletBean() {
		ServletRegistrationBean<PrepareCambiaStatoUtenteServlet> bean = new ServletRegistrationBean<PrepareCambiaStatoUtenteServlet>(
				prepareCambiaStatoUtenteServlet, "/utente/PrepareCambiaStatoUtenteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<PrepareInsertUtenteServlet> createPrepareInsertUtenteServletBean() {
		ServletRegistrationBean<PrepareInsertUtenteServlet> bean = new ServletRegistrationBean<PrepareInsertUtenteServlet>(
				prepareInsertUtenteServlet, "/utente/PrepareInsertUtenteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteInsertUtenteServlet> createExecuteInsertUtenteServletBean() {
		ServletRegistrationBean<ExecuteInsertUtenteServlet> bean = new ServletRegistrationBean<ExecuteInsertUtenteServlet>(
				executeInsertUtenteServlet, "/utente/ExecuteInsertUtenteServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteCambiaStatoUtenteServlet> createExecuteCambiaStatoUtenteServletBean() {
		ServletRegistrationBean<ExecuteCambiaStatoUtenteServlet> bean = new ServletRegistrationBean<ExecuteCambiaStatoUtenteServlet>(
				executeCambiaStatoUtenteServlet, "/utente/ExecuteCambiaStatoUtenteServlet");
		return bean;
	}

}
