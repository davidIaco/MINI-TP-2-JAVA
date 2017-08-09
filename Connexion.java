/** 
 * @author David
 * @version 1.0
 * @see Inscription
 * @see Bienvenue
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Connexion extends JFrame implements ActionListener, KeyListener{

	/**
	 * b1 est le bouton pour acceder à la connection du membre.
	 * text1-2 sont des zones de texte.
	 * lab1-2 definissent les zones de textes.
	 * nbEssai est une variable.
	 */
	private JLabel lab1 = new JLabel ("E-mail :");
	private JLabel lab2 = new JLabel ("Mot de passe :");
	private JTextField text1 = new JTextField ();
	private JTextField text2 = new JTextField ();
	private JButton b1 = new JButton ("Connection");
	private static int nbEssai = 0;


	/**
	 * Mise en place de la fenetre de connection qui permet d'acceder à la fenetre de Bienvenue.
	 */
	Connexion () {

		setVisible(true);		
		setTitle("Connexion");
		setSize(400, 200);
		setLocationRelativeTo(null);
		b1.setEnabled(false);

		lab1.setBounds(20, 20, 150, 20);
		lab2.setBounds(20, 60, 150, 20);
		text1.setBounds(180, 20, 150, 20);
		text2.setBounds(180, 60, 150, 20);
		b1.setBounds(180, 100, 150, 20);

		getContentPane().add(lab1);
		getContentPane().add(text1);
		getContentPane().add(lab2);
		getContentPane().add(text2);
		getContentPane().add(b1);

		b1.addActionListener(this);
		text1.addKeyListener(this);
		text2.addKeyListener(this);

		this.setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	/**
	 * @param event contient la source de l'evenement. 
	 * Boucle de test pour valider si le mail et le mot de passe sont correct et éxistant.
	 * Si oui, on accede à la fenetre de Bienvenue sinon on passe sur la fenetre d'inscription.
	 */
	public void actionPerformed(ActionEvent event ) {

		Object source = event.getSource();
		JOptionPane jop = new JOptionPane();
		String msg = "Mail ou mot de passe incorrect...";
		BufferedReader br = null;

		if ( source == b1) {

			try {

				br = new BufferedReader ( new FileReader ("membre.txt"));

				String ligne1;
				StringTokenizer s=null;
				boolean trouver = false;
				String nomlu=null ;
				String prenomlu =null;
				String mail = null;
				String psw = null;

				while (( (ligne1=br.readLine()) != null) && (!trouver ))  {
					s = new StringTokenizer(ligne1);
					nomlu = s.nextToken();
					prenomlu = s.nextToken();
					mail = s.nextToken();
					psw = s.nextToken();


					if ( (mail.compareTo(text1.getText())== 0) && (psw.compareTo(text2.getText())== 0)) {

						trouver = true;
					}
				}
				if (trouver) {

					Bienvenue p = new Bienvenue();
					Bienvenue.lab1.setText( "Bienvenue "+ prenomlu);
					Bienvenue.lab2.setText( mail);
					this.dispose();

				}


				br.close();

				if (!trouver){

					jop.showMessageDialog(null, msg , "Message", JOptionPane.INFORMATION_MESSAGE);


				} nbEssai++;
				if ( nbEssai >= 3) {

					Inscription p = new Inscription();
					this.dispose();
				}
			}


			catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

	/**
	 * Le bouton Connection est "grisé" tant que les 2 zones de textes ne sont pas remplis.
	 */
	public void keyReleased (KeyEvent e) {

		if  (  (!text1.getText().isEmpty()) && (!text2.getText().isEmpty())) {

			b1.setEnabled(true);

		} else {
			b1.setEnabled(false);
		}
	}

	/**
	 * Le bouton Connection est "grisé" tant que les 2 zones de textes ne sont pas remplis.
	 */
	public void keyPressed (KeyEvent e) {

		if  (  (!text1.getText().isEmpty()) && (!text2.getText().isEmpty())) {

			b1.setEnabled(true);

		} else {
			b1.setEnabled(false);
		}
	}

	/**
	 * Le bouton Connection est "grisé" tant que les 2 zones de textes ne sont pas remplis.
	 */
	public void keyTyped (KeyEvent e) {

		if  (  (!text1.getText().isEmpty()) && (!text2.getText().isEmpty())) {

			b1.setEnabled(true);

		} else {
			b1.setEnabled(false);
		}
	}
}