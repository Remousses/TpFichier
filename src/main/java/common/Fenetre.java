package common;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Fenetre extends JFrame {

	private JPanel contentPane;
	private JTextField text_nom;
	private JTextField text_prenom;
	private JTextField text_rue;
	private JTextField text_cp;
	private JTextField text_ville;
	private JTextField text_tel;
	private JLabel telephone;
	private Personne unePers;
	private Repertoire rep;
	private int numCourant = 0;

	public Fenetre() {
		super();
		
		rep = new Repertoire();
		
		setTitle("REPERTOIRE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("NOM*");
		lblNom.setBounds(131, 14, 36, 14);
		contentPane.add(lblNom);
		
		text_nom = new JTextField();
		text_nom.setBounds(172, 11, 86, 20);
		contentPane.add(text_nom);
		text_nom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("PRENOM*");
		lblPrenom.setBounds(112, 45, 55, 14);
		contentPane.add(lblPrenom);
		
		text_prenom = new JTextField();
		text_prenom.setBounds(172, 42, 114, 20);
		contentPane.add(text_prenom);
		text_prenom.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(10, 99, 55, 14);
		contentPane.add(lblAdresse);
		
		text_rue = new JTextField();
		text_rue.setBounds(65, 96, 149, 20);
		contentPane.add(text_rue);
		text_rue.setColumns(10);
		
		text_cp = new JTextField();
		text_cp.setBounds(224, 96, 55, 20);
		contentPane.add(text_cp);
		text_cp.setColumns(10);
		
		text_ville = new JTextField();
		text_ville.setBounds(289, 96, 135, 20);
		contentPane.add(text_ville);
		text_ville.setColumns(10);
		
		telephone = new JLabel("T�l�phone");
		telephone.setBounds(94, 160, 64, 14);
		contentPane.add(telephone);
		
		text_tel = new JTextField();
		text_tel.setBounds(162, 157, 114, 20);
		contentPane.add(text_tel);
		text_tel.setColumns(10);
		
		//initialise la vue
		afficherPersonne(rep.recherchePersonne(0));
		
		JButton btnAjout = new JButton("AJOUT");
		btnAjout.setBounds(24, 202, 82, 23);
		contentPane.add(btnAjout);
		
		JButton btnPrecedent = new JButton("<< Affiche");
		btnPrecedent.setBounds(112, 202, 96, 23);
		contentPane.add(btnPrecedent);
		
		JButton btnSuivant = new JButton("Affiche >>");
		btnSuivant.setBounds(224, 202, 105, 23);
		contentPane.add(btnSuivant);
		
		JButton btnQuitter = new JButton("QUITTER");
		btnQuitter.setBounds(335, 202, 89, 23);
		contentPane.add(btnQuitter);
		
		btnQuitter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	quitter();
            }
        });
		
		btnAjout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ajoutePers();
            }
        });
		
		btnPrecedent.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	affichePrec();
            }
        });
		
		btnSuivant.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	afficheSuiv();
            }
        });
	}
	
	private void quitter(){
		rep.sauvegarder();
		System.exit(0);
	}
	
	private void ajoutePers(){
		if(!(text_nom.getText().equals("")) && !(text_prenom.getText().equals(""))){ // Si text_nom et text_prenom sont diff�rent de vide faire ceci
			JOptionPane.showMessageDialog(null, "Ajout R�ussi"); // Afficher ce texte
			unePers = new Personne(text_nom.getText(), text_prenom.getText(), new Adresse(text_rue.getText(), text_cp.getText(), text_ville.getText()),text_tel.getText()); // Cr�ation d'une personne
			rep.ajoutePersonne(unePers); // Ajout de la personne au repertoire
			text_nom.setText(""); // Efface le contenu de text_nom
			text_prenom.setText(""); // Efface le contenu de text_prenom
			text_rue.setText(""); // Efface le contenu de text_rue
			text_cp.setText(""); // Efface le contenu de text_cp
			text_ville.setText(""); // Efface le contenu de text_ville
			text_tel.setText(""); // Efface le contenu de text_tel
			numCourant ++;
		}else if(text_nom.getText().equals("") && text_prenom.getText().equals("")){ // Sinon si text_nom et text_prenom sont vide faire ceci
			JOptionPane.showMessageDialog(null, "Il manque le nom et le pr�nom\nVeuillez recommencer"); // Affiche ce texte
		}else if(text_nom.getText().equals("")){ // Sinon si text_nom est vide faire ceci
			JOptionPane.showMessageDialog(null, "Il manque le nom\nVeuillez recommencer"); // Affiche ce texte
		}else if(text_prenom.getText().equals("")){ // Sinon si text_prenom est vide faire ceci
			JOptionPane.showMessageDialog(null, "Il manque le pr�nom\nVeuillez recommencer"); // Affiche ce texte
		}
	}
	
	private void affichePrec(){ // Permet d'afficher la personne pr�c�dente
		try{ // Essayer ceci
			if(numCourant >= 1){ // Si le numCourant est sup�rieur ou �gale � faire ceci 
				numCourant --; // Soustraire 1 � numCourant 
				Personne e = rep.recherchePersonne(numCourant); // Rechercher la personne en fonction du numCourant
				afficherPersonne(e);
			}else{
				afficherMessageErreur();
			}
		}catch(Exception e){ // Permet de voir s'il y a cette exception
			afficherMessageErreur();
			numCourant ++; // Ajout de 1 � numCourant
		}
	}
	
	private void afficheSuiv(){ // Permet d'afficher la personne suivante
		try{ // Essayer ceci
			if(numCourant <= rep.taille()){
				numCourant ++;
				Personne e = rep.recherchePersonne(numCourant); // Rechercher la personne en fonction du numCourant
				afficherPersonne(e);
			}else{
				afficherMessageErreur();
			}
		}catch(Exception e){ // Permet de voir s'il y a cette exception
			afficherMessageErreur();
			numCourant --;
		}
	}

	private void afficherMessageErreur(){
		JOptionPane.showMessageDialog(null, "Vous ne pouvez pas aller plus loin"); // Afficher ce texte
	}

	private void afficherPersonne(Personne e){
		text_nom.setText(e.getNom()); // Affiche le nom � text_nom
		text_prenom.setText(e.getPrenom()); // Affiche le nom � text_prenom
		text_rue.setText(e.getAdresse().getRue()); // Affiche le nom � text_rue
		text_cp.setText(e.getAdresse().getCodePostal()); // Affiche le nom � text_cp
		text_ville.setText(e.getAdresse().getVille()); // Affiche le nom � text_ville
		text_tel.setText(e.getTel()); // Affiche le t�l�phone � text_tel
	}
}