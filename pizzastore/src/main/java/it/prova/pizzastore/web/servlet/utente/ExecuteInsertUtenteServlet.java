package it.prova.pizzastore.web.servlet.utente;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.pizzastore.dto.UtenteDTO;
import it.prova.pizzastore.model.StatoUtente;
import it.prova.pizzastore.service.RuoloService;
import it.prova.pizzastore.service.UtenteService;

@Component
public class ExecuteInsertUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService serviceUtente;

	@Autowired
	private RuoloService ruoloService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String usernameParam = request.getParameter("username");
		String passwordParam = request.getParameter("password");
		

		UtenteDTO utenteInstance = UtenteDTO.createUtenteDTOFromParams(nomeParam, cognomeParam, usernameParam,
				passwordParam, null, null);
		utenteInstance.setDateCreated(new Date());
		utenteInstance.setStato(StatoUtente.CREATO);

		utenteInstance.validate();

		if (utenteInstance.hasErrors()) {
			request.setAttribute("insert_utente_attr", utenteInstance);
			request.setAttribute("ruoli_list_attribute", ruoloService.listAll());
			request.getRequestDispatcher("/utente/insert.jsp").forward(request, response);
			return;
		}

		try {

			serviceUtente.inserisciNuovo(utenteInstance.buildUtenteModel());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/utente/insert.jsp").forward(request, response);
			return;
		}

		response.sendRedirect("ExecuteListUtenteServlet?operationResult=SUCCESS");
	}

}