package it.prova.pizzastore.web.servlet.utente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.municipioabitantespringbootservletjpa.model.StatoUtente;
import it.prova.municipioabitantespringbootservletjpa.model.Utente;
import it.prova.municipioabitantespringbootservletjpa.service.UtenteService;

//@Component
public class ExecuteCambiaStatoUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService serviceUtente;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idUtenteParam = request.getParameter("idUtente");

		if (!NumberUtils.isCreatable(idUtenteParam)) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			request.setAttribute("errorMessage", "Attenzione si è verificato un erroreeeee.");
			request.getRequestDispatcher("utente/list.jsp").forward(request, response);
			return;
		}

		try {
			Utente utenteDaModificare = serviceUtente.findOneEagerRuoli(Long.parseLong(idUtenteParam));

			if (utenteDaModificare.isAdmin() && serviceUtente.unicoAdminRimastoAttivo()
					&& utenteDaModificare.getStato().name().equalsIgnoreCase(StatoUtente.ATTIVO.name())) {
				// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
				request.setAttribute("errorMessage", "Non posso disattivare l'unico admin attivo.");
				request.setAttribute("utenti_list_attribute", serviceUtente.listAll());
				request.getRequestDispatcher("/utente/list.jsp").forward(request, response);
				return;
			}

			if (utenteDaModificare.getStato() == StatoUtente.ATTIVO) {
				utenteDaModificare.setStato(StatoUtente.DISABILITATO);
			} else {
				utenteDaModificare.setStato(StatoUtente.ATTIVO);
			}

			serviceUtente.aggiorna(utenteDaModificare);

			request.setAttribute("utenti_list_attribute", serviceUtente.listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			// qui ci andrebbe un messaggio nei file di log costruito ad hoc se fosse attivo
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("home").forward(request, response);
			return;
		}

		response.sendRedirect("ExecuteListUtenteServlet?operationResult=SUCCESS");
	}

}
