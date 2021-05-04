package it.prova.pizzastore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.prova.pizzastore.model.Ordine;
import it.prova.pizzastore.repository.ordine.OrdineRepository;

public class OrdineServiceImpl implements OrdineService {

	@Autowired
	private OrdineRepository repository;

	@Override
	public List<Ordine> listAllOrdine() {
		return (List<Ordine>) repository.findAll();
	}

	@Override
	public Ordine caricaSingoloOrdine(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void aggiorna(Ordine ordineInstance) {
		repository.save(ordineInstance);

	}

	@Override
	public void inserisciNuovo(Ordine ordineInstance) {
		repository.save(ordineInstance);

	}

	@Override
	public void rimuovi(Ordine ordineInstance) {
		repository.delete(ordineInstance);

	}

	@Override
	public List<Ordine> findByExample(Ordine example) {
		throw new RuntimeException("da implementare");
	}

}
