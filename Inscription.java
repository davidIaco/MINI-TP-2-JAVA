/** 
 * @author David
 * @version 1.0
 * @see Bienvenue
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Inscription extends JFrame implements ActionListener, KeyListener{

	/**
	 * b1 est le bouton pour acceder à l'insciption du membre.
	 * text1-2-3 sont des zones de texte.
	 * lab1-2-3 definissent les zones de textes.
	 * mail et nbUser sont des variables.
	 */
	private JLabel lab1 = new JLabel ("Nom :");
	private JLabel lab2 = new JLabel ("Prenom :");
	private JLabel lab3 = new JLabel ("Mot de passe :");
	private JTextField text1 = new JTextField ();
	static JTextField text2 = new JTextField ();
	private JTextField text3 = new JTextField ();
	private JButton b1 = new JButton ("Inscription");
	public static String mail;
	private static int nbUser = 1;


	/**
	 * Mise en place de la fenetre d'inscription qui permet d'ajouter un membre.
	 */
	Inscription () {

		setVisible(true);		
		setTitle("Inscription");
		setSize(400, 280);
		setLocationRelativeTo(null);
		b1.setEnabled(false);

		lab1.setBounds(20, 20, 150, 20);
		lab2.setBounds(20, 60, 150, 20);
		lab3.setBounds(20, 100, 150, 20);
		text1.setBounds(180, 20, 150, 20);
		text2.setBounds(180, 60, 150, 20);
		text3.setBounds(180, 100, 150, 20);
		b1.setBounds(180, 160, 150, 20);

		getContentPane().add(lab1);
		getContentPane().add(text1);
		getContentPane().add(lab2);
		getContentPane().add(text2);
		getContentPane().add(lab3);
		getContentPane().add(text3);
		getContentPane().add(b1);

		b1.addActionListener(this);
		text1.addKeyListener(this);
		text2.addKeyListener(this);
		text3.addKeyListener(this);
		nbUser++;

		this.setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	/**
	 * @param event contient la source de l'evenement. 
	 * Boucle de test pour valider l'ajout du membre et affiche la fenetre de Bienvenue.
	 */
	public void actionPerformed(ActionEvent event ) {

		Object source = event.getSource();
		BufferedReader br = null;
		BufferedWriter bw = null;


		if ( source == b1) {

			mail = text1.getText() + "." + text2.getText() + "." + nbUser + "@mii.fr" + " ";
			String ligne = text1.getText() + " " + text2.getText() + " " + mail + text3.getText() + " ";

			try {
				br = new BufferedReader ( new FileReader ("membre.txt"));
				bw = new BufferedWriter (new FileWriter ("membre.txt", true));


				bw.write(ligne);
				bw.newLine();
				bw.close();
				br.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();
			} 
		} 

		Bienvenue p = new Bienvenue();

		Bienvenue.lab1.setText( "Bienvenue " + text2.getText());
		Bienvenue.lab2.setText( mail);

		this.dispose();
	}


/**
 * Le bouton Inscription est "grisé" tant que les 3 zones de textes ne sont pas remplis.
 */
	public void keyReleased (KeyEvent e) {

		if  (  (!text1.getText().isEmpty()) && (!text2.getText().isEmpty()) 
				&& (!text3.getText().isEmpty())) {

			b1.setEnabled(true);

		} else {
			b1.setEnabled(false);
		}

	}

	/**
	 * Le bouton Inscription est "grisé" tant que les 3 zones de textes ne sont pas remplis.
	 */
	public void keyPressed (KeyEvent e) {

		if  (  (!text1.getText().isEmpty()) && (!text2.getText().isEmpty()) 
				&& (!text3.getText().isEmpty())) {

			b1.setEnabled(true);

		} else {
			b1.setEnabled(false);
		}
	}
	
	/**
	 * Le bouton Inscription est "grisé" tant que les 3 zones de textes ne sont pas remplis.
	 */
	public void keyTyped (KeyEvent e) {

		if  (  (!text1.getText().isEmpty()) && (!text2.getText().isEmpty()) 
				&& (!text3.getText().isEmpty())) {

			b1.setEnabled(true);

		} else {
			b1.setEnabled(false);
		}
	}
}
