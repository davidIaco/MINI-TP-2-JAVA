/** 
 * @author David
 * @version 1.0
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Accueil extends JFrame implements ActionListener{

	/**
	 * b1 est le bouton pour acceder à la connexion.
	 * b2 est le bouton pour acceder à l'insciption.
	 * b3 est le bouton pour fermer la fenetre.
	 */
	private JButton b1 = new JButton ("Connexion");
	private JButton b2 = new JButton ("Inscription");
	private JButton b3 = new JButton ("Quitter");



	/**
	 * Position de b1.
	 * Position de b2.
	 * Position de b3.
	 */
	Accueil () {

		setVisible(true);		
		setTitle("Accueil");
		setSize(280, 200);
		setLocationRelativeTo(null);

		b1.setBounds(60, 60, 150, 20);
		b2.setBounds(60, 20, 150, 20);
		b3.setBounds( 60, 100, 150,20);

		getContentPane().add(b1);
		getContentPane().add(b2);
		getContentPane().add(b3);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		this.setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}


	/**
	 * @param event contient la source de l'evenement. 
	 * Boucle de test pour valider l'acces à la prochaine fenetre.
	 * 
	 */
	public void actionPerformed(ActionEvent event ) {

		Object source = event.getSource();

		if ( source == b3) {
			
			this.dispose();
			
		} if ( source == b1) {
			
			Connexion p = new Connexion();
			this.dispose();
			
		} if ( source == b2) {
			
			Inscription p = new Inscription();
			this.dispose();
		}
	}
}
