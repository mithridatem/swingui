package vue;

import config.Regex;
import controller.UserController;
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
        JOptionPane.showConfirmDialog(
                this,
                UserController.insertUser(nom, prenom, email, password, confirm),
                "Erreur :",
                JOptionPane.ERROR_MESSAGE ) ;
    }
}
