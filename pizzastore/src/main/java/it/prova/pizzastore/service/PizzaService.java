package it.prova.pizzastore.service;

import java.util.List;

import it.prova.pizzastore.model.Pizza;

public interface PizzaService {

	public List<Pizza> listAllPizza();

	public Pizza caricaSingoloPizza(Long id);

	public void aggiorna(Pizza pizzaInstance);

	public void inserisciNuovo(Pizza pizzaInstance);

	public void rimuovi(Pizza pizzaInstance);

	public List<Pizza> findByExample(Pizza example);

}