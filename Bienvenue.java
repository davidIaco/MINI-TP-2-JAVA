/** 
 * @author David
 * @version 1.0
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Bienvenue extends JFrame implements ActionListener {
	
	/**
	 * @param b1 est un bouton.
	 * lab1-2 definissent les zones de textes.
	 */
	private JButton b1 = new JButton ("Quitter");
	static JLabel lab1 = new JLabel ("Bienvenue ");
	static JLabel lab2 = new JLabel ();
	
	
	/**
	 * Mise en place de la fenetre de Bienvenue qui permet d'afficher le prénom et l'adresse mail du membre.
	 */
	Bienvenue () {
		
		setVisible(true);		
		setTitle("Bienvenue");
		setSize(300, 200);
		setLocationRelativeTo(null);
		
		b1.setBounds(80, 100, 150, 20);
		lab1.setBounds(100, 20, 150, 20);
		lab2.setBounds(90, 50, 150, 20);
		
		getContentPane().add(b1);
		getContentPane().add(lab1);
		getContentPane().add(lab2);
		
		b1.addActionListener(this);
		
		this.setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	/**
	 * @param event contient la source de l'evenement. 
	 * Boucle de test pour fermer la fenetre si le bouton Quitter est actionner.
	 */
public void actionPerformed(ActionEvent event ) {
	
		Object source = event.getSource();
		
		if ( source == b1) {
			this.dispose();
		}
	}
}
