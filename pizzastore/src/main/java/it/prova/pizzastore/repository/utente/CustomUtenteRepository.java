package it.prova.pizzastore.repository.utente;

import java.util.List;

import it.prova.pizzastore.model.Utente;

public interface CustomUtenteRepository {

	List<Utente> findByExample(Utente example);

	Utente findOneEagerRuoli(Long id);
	
	Long countByUtenteAdminAttivo();

}
