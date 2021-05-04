package it.prova.pizzastore;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.pizzastore.model.Ruolo;
import it.prova.pizzastore.model.StatoUtente;
import it.prova.pizzastore.model.Utente;
import it.prova.pizzastore.service.RuoloService;
import it.prova.pizzastore.service.UtenteService;

@SpringBootApplication
public class PizzastoreApplication implements CommandLineRunner {

	@Autowired
	private RuoloService ruoloServiceInstance;
	@Autowired
	private UtenteService utenteServiceInstance;

	public static void main(String[] args) {
		SpringApplication.run(PizzastoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ADMIN_ROLE") == null) {
//			ruoloServiceInstance.inserisciNuovo(new Ruolo("Administrator", "ADMIN_ROLE"));
//		}
//
//		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Pizzaiolo", "PIZZAIOLO_ROLE") == null) {
//			ruoloServiceInstance.inserisciNuovo(new Ruolo("Pizzaiolo", "PIZZAIOLO_ROLE"));
//		}
//		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Fattorino", "FATTORINO_ROLE") == null) {
//			ruoloServiceInstance.inserisciNuovo(new Ruolo("Fattorino", "FATTORINO_ROLE"));
//		}
//
//		if (utenteServiceInstance.findByUsernameAndPassword("admin", "admin") == null) {
//			Utente admin = new Utente("admin", "admin", "Mario", "Rossi", new Date());
//			admin.setStato(StatoUtente.ATTIVO);
//			admin.getRuoli().add(ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ADMIN_ROLE"));
//			utenteServiceInstance.inserisciNuovo(admin);
////			utenteServiceInstance.aggiungiRuolo(admin,
////					ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN"));
//		}
//
//		if (utenteServiceInstance.findByUsernameAndPassword("user", "user") == null) {
//			Utente admin = new Utente("user", "user", "Antonio", "Verdi", new Date());
//			admin.setStato(StatoUtente.ATTIVO);
//			admin.getRuoli().add(ruoloServiceInstance.cercaPerDescrizioneECodice("Pizzaiolo", "PIZZAIOLO_ROLE"));
//			utenteServiceInstance.inserisciNuovo(admin);
////			utenteServiceInstance.aggiungiRuolo(admin,
////					ruoloServiceInstance.cercaPerDescrizioneECodice("Classic User", "ROLE_CLASSIC_USER"));
//		}
//
//		if (utenteServiceInstance.findByUsernameAndPassword("fatto", "rino") == null) {
//			Utente admin = new Utente("fatto", "rino", "Gimbo", "Giambo", new Date());
//			admin.setStato(StatoUtente.ATTIVO);
//			admin.getRuoli().add(ruoloServiceInstance.cercaPerDescrizioneECodice("Fattorino", "FATTORINO_ROLE"));
//			utenteServiceInstance.inserisciNuovo(admin);
////			utenteServiceInstance.aggiungiRuolo(admin,
////					ruoloServiceInstance.cercaPerDescrizioneECodice("Classic User", "ROLE_CLASSIC_USER"));
//		}

	}

}
