package it.prova.pizzastore.web.servlet.registration;

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
import it.prova.pizzastore.service.UtenteService;

@Component
public class ExecuteIscrivitiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService serviceUtente;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// estraggo input
		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String usernameParam = request.getParameter("username");
		String passwordParam = request.getParameter("password");
		String confermaPasswordParam = request.getParameter("confermaPassword");

		UtenteDTO utenteDTOInstance = UtenteDTO.createUtenteDTOFromParams(nomeParam, cognomeParam, usernameParam, "",
				"", "");

		System.out.println(utenteDTOInstance);

		// se le due password non corrispondono rimando in subscribe.jsp con i dati
		// riempiti senza le password
		if (!passwordParam.equals(confermaPasswordParam)) {
			request.setAttribute("errorMessage", "Le due password devono essere uguali");
			request.setAttribute("registration_utente_attr", utenteDTOInstance);
			request.getRequestDispatcher("/registration/subscribe.jsp").forward(request, response);
			return;
		}

		// riempo il bean con i dati mancanti
		utenteDTOInstance.setPassword(passwordParam);
		utenteDTOInstance.setDateCreated(new Date());
		utenteDTOInstance.setStato(StatoUtente.CREATO);

		utenteDTOInstance.validate();

		// se la validazione non risulta ok
		if (utenteDTOInstance.hasErrors()) {
			request.setAttribute("registration_utente_attr", utenteDTOInstance);
			request.getRequestDispatcher("/registration/subscribe.jsp").forward(request, response);
			return;
		}

		// se sono qui i valori sono ok quindi posso creare l'oggetto da inserire
		// occupiamoci delle operazioni di business
		try {
			serviceUtente.inserisciNuovo(utenteDTOInstance.buildUtenteModel());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/registration/subscribe.jsp").forward(request, response);
			return;
		}

		response.sendRedirect(request.getContextPath() + "/home");
	}

}
