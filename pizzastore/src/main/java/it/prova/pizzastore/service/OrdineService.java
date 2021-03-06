package it.prova.pizzastore.service;

import java.util.List;

import it.prova.pizzastore.model.Ordine;

public interface OrdineService {

	public List<Ordine> listAllOrdine();

	public Ordine caricaSingoloOrdine(Long id);

	public void aggiorna(Ordine ordineInstance);

	public void inserisciNuovo(Ordine ordineInstance);

	public void rimuovi(Ordine ordineInstance);

	public List<Ordine> findByExample(Ordine example);

}
