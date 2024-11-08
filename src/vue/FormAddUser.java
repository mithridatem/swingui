package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormAddUser extends JDialog{
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
    private JButton btAdd;

    //Constructeur
    public FormAddUser(JDialog parent){
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
        btAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("J'ai cliqué sur le bouton");
                recupUser();
            }
        });
    }

    public void recupUser(){
        System.out.println(tfNom.getText());
        System.out.println(tfPrenom.getText());
        System.out.println(tfEmail.getText());
        System.out.println(pfPassword.getPassword());
        System.out.println(pfConfirm.getPassword());
    }
}
