package it.prova.pizzastore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Ordine( 
//Utente cioè il fattorino a cui assegnare l’ordine, ).

@Entity
@Table(name = "ordine")
public class Ordine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "data")
	private Date data;
	@Column(name = "closed")
	private boolean closed;
	@Column(name = "codice")
	private String codice;
	@Column(name = "costoTotaleOrdine")
	private String costoTotaleOrdine;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "utente_id")
	private Utente utente;

	@ManyToMany
	@JoinTable(name = "ordine_pizza", joinColumns = @JoinColumn(name = "ordine_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "ID"))
	private List<Pizza> pizze = new ArrayList<>(0);

	public Ordine() {
		super();
	}

	public Ordine(Date data, boolean closed, String codice, String costoTotaleOrdine) {
		super();
		this.data = data;
		this.closed = closed;
		this.codice = codice;
		this.costoTotaleOrdine = costoTotaleOrdine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getCostoTotaleOrdine() {
		return costoTotaleOrdine;
	}

	public void setCostoTotaleOrdine(String costoTotaleOrdine) {
		this.costoTotaleOrdine = costoTotaleOrdine;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<Pizza> getPizze() {
		return pizze;
	}

	public void setPizze(List<Pizza> pizze) {
		this.pizze = pizze;
	}

	@Override
	public String toString() {
		return "Ordine [id=" + id + ", data=" + data + ", closed=" + closed + ", codice=" + codice
				+ ", costoTotaleOrdine=" + costoTotaleOrdine + "]";
	}

}
