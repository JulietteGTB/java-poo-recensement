package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.exceptions.UserException;

import static fr.diginamic.recensement.utils.SaisieUtils.getValidDepCode;
import static fr.diginamic.recensement.utils.SaisieUtils.getValidInt;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws UserException {

		System.out.println("Quel est le code du département recherché ? ");
		String choix = getValidDepCode(rec, scanner);

		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		int min = getValidInt(scanner);

		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		int max = getValidInt(scanner);

		if(min>max) {
			throw new UserException("Le minimum ne peut pas être plus grand que le maximum.");
		}

		List<Ville> villes = rec.getVilles();
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
			}
		}
	}




}
