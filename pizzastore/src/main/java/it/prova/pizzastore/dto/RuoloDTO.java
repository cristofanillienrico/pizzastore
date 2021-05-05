package it.prova.pizzastore.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import it.prova.pizzastore.model.Ruolo;

public class RuoloDTO {

	private Long id;
	private String descrizione;
	private String codice;

	private List<String> errors = new ArrayList<String>();

	public RuoloDTO() {
		super();
	}

	public RuoloDTO(Long id) {
		super();
		this.id = id;
	}

	public RuoloDTO(String descrizione, String codice) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public RuoloDTO(Long id, String descrizione, String codice) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "RuoloDTO [id=" + id + ", descrizione=" + descrizione + ", codice=" + codice + "]";
	}

	public void validate() {
		List<String> validationResult = new ArrayList<String>();

		if (StringUtils.isBlank(this.descrizione))
			validationResult.add("Il campo 'Descrizione' non può essere vuoto");
		if (StringUtils.isBlank(this.codice))
			validationResult.add("Il campo 'Codice' non può essere vuoto");

		this.setErrors(validationResult);
	}

	public boolean hasErrors() {
		return this.errors != null && !this.errors.isEmpty();
	}

	public Ruolo buildRuoloModel() {
		return new Ruolo(this.id, this.descrizione, this.codice);
	}

	public static RuoloDTO buildRuoloDTOFromModel(Ruolo ruoloModel) {
		return new RuoloDTO(ruoloModel.getId(), ruoloModel.getDescrizione(), ruoloModel.getCodice());
	}

	public static RuoloDTO createRuoloDTOFromParams(String descrizioneInputParam, String codiceInputParam) {

		RuoloDTO result = new RuoloDTO(descrizioneInputParam, codiceInputParam);
		return result;
	}

	public static RuoloDTO createRuoloDTOFromParamsID(String idInputParam) {

		RuoloDTO result = new RuoloDTO(Long.parseLong(idInputParam));
		return result;
	}

	public static List<RuoloDTO> createRuoloDTOListFromModelList(List<Ruolo> modelListInput) {
		return modelListInput.stream().map(ruoloEntity -> {
			return RuoloDTO.buildRuoloDTOFromModel(ruoloEntity);
		}).collect(Collectors.toList());
	}

}
