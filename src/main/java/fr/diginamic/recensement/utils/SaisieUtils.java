package fr.diginamic.recensement.utils;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.exceptions.UserException;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class SaisieUtils {
    public static int getValidInt(Scanner scanner) throws UserException {
        String input = scanner.nextLine();

        if (!NumberUtils.isDigits(input)) {
            throw new UserException("Input must be a number.");
        }
        int saisie = Integer.parseInt(input) * 1000;
        return saisie;
    }

    public static String getValidDepCode(Recensement rec, Scanner scanner) throws UserException {
        String choix = scanner.nextLine();
        boolean checkCode = false;
        for (Ville ville : rec.getVilles()) {
            if(ville.getCodeDepartement().equals(choix)) {
                checkCode = true;
                break;
            }
        }
        if (!checkCode) {
            throw new UserException("This region code does not exist.");
        }
        return choix;
    }
}
