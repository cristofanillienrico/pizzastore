package it.prova.pizzastore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.prova.pizzastore.model.Pizza;
import it.prova.pizzastore.repository.pizza.PizzaRepository;

public class PizzaServiceImpl implements PizzaService {

	@Autowired
	private PizzaRepository repository;

	@Override
	public List<Pizza> listAllPizza() {
		return (List<Pizza>) repository.findAll();
	}

	@Override
	public Pizza caricaSingoloPizza(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void aggiorna(Pizza pizzaInstance) {
		repository.save(pizzaInstance);

	}

	@Override
	public void inserisciNuovo(Pizza pizzaInstance) {
		repository.save(pizzaInstance);

	}

	@Override
	public void rimuovi(Pizza pizzaInstance) {
		repository.delete(pizzaInstance);

	}

	@Override
	public List<Pizza> findByExample(Pizza example) {
		throw new RuntimeException("da implementare");
	}

}
