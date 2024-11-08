package vue;

import config.Regex;
import model.User;
import validator.Validation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormAddUser extends JDialog {
    //Attributs
    private JPanel jpMain;
    private JLabel jlTitre;
    private JLabel jlNom;
    private JTextField tfNom;
    private JLabel jlPrenom;
    private JTextField tfPrenom;
    private JLabel jlEmail;
    private JTextField tfEmail;
    private JLabel jlPassword;
    private JPasswordField pfPassword;
    private JLabel jlConfirm;
    private JPasswordField pfConfirm;
    private JButton btQuit;
    private JButton btAdd;

    //Constructeur
    public FormAddUser(JDialog parent) {
        super(parent);
        //initialiser le titre
        setTitle("Ajouter un compte");
        //déclarer le container
        setContentPane(jpMain);
        //taille minimum
        setMinimumSize(new Dimension(500, 600));
        setMaximumSize(new Dimension(500, 600));
        //indiquer si la fenêtre est un modal
        setModal(false);
        //Indiquer que la fenêtre est visible
        setVisible(true);
        //Fermer par la croix en haut à droite
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //Action Listener bouton ajouter
        btAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
            }
        });
        //Action Listener bouton quitter
        btQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void addUser() {
        //récupérer les 5 inputs
        String nom = tfNom.getText();
        String prenom = tfPrenom.getText();
        String email = tfEmail.getText();
        String password = String.valueOf(pfPassword.getPassword());
        String confirm = String.valueOf(pfConfirm.getPassword());
        //Tester si les 5 inputs sont différents de vide
        if (!nom.isEmpty() && !prenom.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confirm.isEmpty()) {
            //Test si les champs sont plus petit que 50
            if (Validation.isLengthMax(nom, 50) && Validation.isLengthMax(prenom, 50)
                    && Validation.isLengthMax(email, 50)) {
                //Tester si le mail est valide
                if (Validation.isValid(email, Regex.EMAIL_REGEX)) {
                    //Tester si le mot de passe est conforme (regex)
                    if (Validation.isValid(password, Regex.PASSWORD_REGEX)) {
                        //Test si les 2 mots de passe correspondent
                        if (password.equals(confirm)) {
                            User newUser = new User(nom, prenom, email, password);
                            JOptionPane.showMessageDialog(
                                    this,
                                    "Le compte a été ajouté",
                                    "Valid",
                                    JOptionPane.OK_OPTION
                            );
                        }
                        //Sinon les mots de passe sont différents
                        else {
                            JOptionPane.showMessageDialog(
                                    this,
                                    "Erreur les mots de passe ne correspondent pas",
                                    "Erreur",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }
                    }
                    //Sinon les mot de passe ne sont pas conforme (regex)
                    else {
                        JOptionPane.showMessageDialog(
                                this,
                                "Le mot de passe est invalide",
                                "Erreur",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
                //Sinon le mail est incorrect
                else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Le mail est invalide",
                            "Erreur",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
            //Sinon nom, prénom et email sont trop grands
            else {
                JOptionPane.showMessageDialog(
                        this,
                        "Les valeurs de non, prénom et email sont trop grands",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
        //Sinon les champs ne sont pas remplis
        else {
            JOptionPane.showMessageDialog(
                    this,
                    "Veuillez remplir tous les champs du formulaire",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
