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
    //Ajouter un compte
    public void addUser() {
        //récupérer les 5 inputs
        String nom = tfNom.getText();
        String prenom = tfPrenom.getText();
        String email = tfEmail.getText();
        String password = String.valueOf(pfPassword.getPassword());
        String confirm = String.valueOf(pfConfirm.getPassword());
        //Récupére le message de l'ajout
        popup(UserController.insertUser(nom, prenom, email, password, confirm));
    }
    //Méthode qui affiche le popup
    public void popup(String message) {
        //Découpe le message
        String firstChar = message.substring(0, 1);
        //titre et le type du Jdialog
        String titre = "";
        int type = 0;
        //Test si le message commence par E
        if(firstChar.equals("E")) {
            titre = "Erreur";
        }
        //sinon commence par autre chose
        else {
            titre = "Valide";
            type = 1;
        }
        //Afficher le message
        JOptionPane.showMessageDialog(this, message , titre, type);
    }
}
