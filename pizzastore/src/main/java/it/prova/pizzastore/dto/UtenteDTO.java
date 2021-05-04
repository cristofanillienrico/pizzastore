package it.prova.pizzastore.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import it.prova.pizzastore.model.StatoUtente;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.utility.Utility;

public class UtenteDTO {
	private Long id;
	private String username;
	private String password;
	private String nome;
	private String cognome;
	private Date dateCreated;
	private StatoUtente stato = StatoUtente.CREATO;

	private List<String> errors = new ArrayList<String>();

	public UtenteDTO() {
		super();
	}

	public UtenteDTO(Long id) {
		super();
		this.id = id;
	}

	public UtenteDTO(Long id, String username, String password, String nome, String cognome, Date dateCreated,
			StatoUtente stato) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.dateCreated = dateCreated;
		this.stato = stato;
	}

	public UtenteDTO(String nome, String cognome, String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public StatoUtente getStato() {
		return stato;
	}

	public void setStato(StatoUtente stato) {
		this.stato = stato;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public void validate() {
		List<String> validationResult = new ArrayList<String>();

		if (StringUtils.isBlank(this.nome))
			validationResult.add("Il campo 'Nome' non può essere vuoto");
		if (StringUtils.isBlank(this.cognome))
			validationResult.add("Il campo 'Cognome' non può essere vuoto");
		if (StringUtils.isBlank(this.username))
			validationResult.add("Il campo 'Username' non può essere vuoto");
		if (StringUtils.isBlank(this.password))
			validationResult.add("Il campo 'Password' non può essere vuoto");
		if (this.stato == null)
			validationResult.add("Il campo 'Stato' non può essere vuoto");
		if (this.dateCreated == null)
			validationResult.add("Il campo 'Data di Creazione' non può essere vuoto");

		this.setErrors(validationResult);
	}

	public boolean hasErrors() {
		return this.errors != null && !this.errors.isEmpty();
	}

	public Utente buildUtenteModel() {
		return new Utente(this.id, this.nome, this.cognome, this.username, this.password, this.dateCreated, this.stato);
	}

	public static UtenteDTO buildUtenteDTOFromModel(Utente utenteModel) {
		return new UtenteDTO(utenteModel.getId(), utenteModel.getNome(), utenteModel.getCognome(),
				utenteModel.getUsername(), utenteModel.getPassword(), utenteModel.getDateCreated(),
				utenteModel.getStato());
	}

	public static UtenteDTO createUtenteDTOFromParams(String nomeInputParam, String cognomeInputParam,
			String usernameInputParam, String passwordInputParam, String dataCreatedStringParam, String statoParam) {

		UtenteDTO result = new UtenteDTO(nomeInputParam, cognomeInputParam, usernameInputParam, passwordInputParam);
		result.setStato(StringUtils.isBlank(statoParam) ? null : StatoUtente.valueOf(statoParam));
		result.setDateCreated(Utility.parseDateFromString(dataCreatedStringParam));
		return result;
	}

	public static List<UtenteDTO> createRegistaDTOListFromModelList(List<Utente> modelListInput) {
		return modelListInput.stream().map(utenteEntity -> {
			return UtenteDTO.buildUtenteDTOFromModel(utenteEntity);
		}).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "UtenteDTO [id=" + id + ", username=" + username + ", password=" + password + ", nome=" + nome
				+ ", cognome=" + cognome + ", dateCreated=" + dateCreated + ", stato=" + stato + "]";
	}

}
