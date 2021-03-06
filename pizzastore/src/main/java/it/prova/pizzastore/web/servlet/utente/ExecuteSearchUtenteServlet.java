package it.prova.pizzastore.web.servlet.utente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.pizzastore.dto.RuoloDTO;
import it.prova.pizzastore.dto.UtenteDTO;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.service.UtenteService;

@Component
public class ExecuteSearchUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeParam = request.getParameter("nome");
		String cognomeParam = request.getParameter("cognome");
		String usernameParam = request.getParameter("username");
		String dateCreatedParam = request.getParameter("dateCreated");
		String statoParam = request.getParameter("stato");

		String ruoloParam = request.getParameter("ruolo_id");

		try {
			UtenteDTO utenteDTOInstance = UtenteDTO.createUtenteDTOFromParamsWhitoutPassword(nomeParam, cognomeParam,
					usernameParam, dateCreatedParam, statoParam);

			Utente example = utenteDTOInstance.buildUtenteModel();

			if (!StringUtils.isBlank(ruoloParam)) {
				RuoloDTO ruoloDTOInstance = RuoloDTO.createRuoloDTOFromParamsID(ruoloParam);
				example.getRuoli().add(ruoloDTOInstance.buildRuoloModel());
			}

			request.setAttribute("utenti_list_attribute", utenteService.findByExample(example));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/utente/search.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/utente/list.jsp").forward(request, response);
	}

}
