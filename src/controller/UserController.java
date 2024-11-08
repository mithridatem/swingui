package controller;

import config.Regex;
import model.User;
import validator.Validation;

public class UserController {

    public static String insertUser(String nom, String prenom, String email, String confirm, String password) {
        //Tester si les 5 inputs sont différents de vide
        if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
            return "Veuillez remplir tous les champs du formulaire";
        }
        //Test si les champs sont plus grand que 50
        if (!Validation.isLengthMax(nom, 50) || !Validation.isLengthMax(prenom, 50)
                || !Validation.isLengthMax(email, 50)) {
            return "Les valeurs de nom, prénom et email sont trop grands";
        }
        //Tester si le mail est valide
        if (!Validation.isValid(email, Regex.EMAIL_REGEX)) {
            return "Le mail est invalide";
        }
        //Tester si le mot de passe est conforme (regex)
        if (!Validation.isValid(password, Regex.PASSWORD_REGEX)) {
            return "Le mot de passe est invalide";
        }
        //Test si les 2 mots de passe correspondent
        if (!password.equals(confirm)) {
            return "les mots de passe ne sont pas identique";
        }
        //Création d'un objet User
        User user = new User(nom, prenom, email, password);
        //Test si le compte existe en BDD
        if(user.findUserExist()) {
            return "Le compte existe déja en BDD";
        }
        //Hash du mot de passe
        user.hashPassword();
        //Ajout du compte en BDD
        user.add();
        return "Valide : Le compte à été ajouté";
    }
}
