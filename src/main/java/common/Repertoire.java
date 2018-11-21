package common;

import java.util.ArrayList;
import java.util.Collections;

public class Repertoire {
	private ArrayList<Personne> repertoire;
	
	public Repertoire(){
		repertoire = Fichier.lecture();
	}
	
	public void ajoutePersonne(Personne unePersonne){
		repertoire.add(unePersonne);
		Collections.sort(repertoire);
	}
	
	public Personne rechercheNom(String nom){
		Personne laPersonne = null;
		for(Personne e : repertoire){
			if(e.getNom().equals(nom)){
				laPersonne = e;
			}
		}
		return laPersonne;
	}
	
	public Personne rechercheNomPrenom(String nom, String prenom){
		Personne laPersonne = null;
		for(Personne e : repertoire){
			if(e.getNom().equals(nom) && e.getPrenom().equals(prenom)){
				laPersonne = e;
			}
		}
		return laPersonne;
	}
	
	public Personne recherchePersonne(int index){
		return repertoire.get(index);
	}

	public void sauvegarder(){
		Fichier.ecriture(repertoire);
	}
	
	public int taille(){
		return repertoire.size();
	}
}
