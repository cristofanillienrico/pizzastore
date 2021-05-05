package it.prova.pizzastore.web.servlet.utente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.pizzastore.dto.UtenteDTO;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.service.UtenteService;

@Component
public class ExecuteVisualizzaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService serviceUtente;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idUtenteParam = request.getParameter("idUtente");

		if (!NumberUtils.isCreatable(idUtenteParam)) {

			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		try {
			Utente utenteInstance = serviceUtente.findOneEagerRuoli(Long.parseLong(idUtenteParam));
			UtenteDTO utenteDTOInstance = UtenteDTO.buildUtenteDTOFromModel(utenteInstance);

			if (utenteDTOInstance == null) {
				response.sendRedirect("ExecuteListUtenteServlet?operationResult=NOT_FOUND");
				return;
			}

			request.setAttribute("show_ruolo_attr", utenteInstance.getRuoli());

			request.setAttribute("show_utente_attr", utenteDTOInstance);
		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/utente/show.jsp").forward(request, response);
	}

}