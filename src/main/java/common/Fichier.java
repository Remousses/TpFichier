package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Fichier {
	
	public static ArrayList<Personne> lecture(){
		ArrayList<Personne> liste = new ArrayList<>();
		
		try{
			FileReader fr = new FileReader("repertoire.txt");
			BufferedReader fichier = new BufferedReader(fr);
			
			String ligne;
			
			while((ligne = fichier.readLine()) != null){
				String Laligne[]=ligne.split(";");
				String adr[]=Laligne[2].split(",");
			    Adresse a = new Adresse(adr[0],adr[1],adr[2]);
				Personne e = new Personne(Laligne[0],Laligne[1],a,Laligne[3]);
				
				liste.add(e);
			}
			
			fichier.close();
		}catch(FileNotFoundException e){
			System.out.println("Erreur : le fichier n'existe pas !\n" + e);
		}
		catch(IOException e){
			System.out.println("Erreur :\n" + e);
		}

		return liste;
	}
	
	public static void ecriture(ArrayList<Personne> liste){
		try{
			FileWriter fw = new FileWriter("repertoire.txt");
			BufferedWriter fichier = new BufferedWriter(fw);
			
			for (Personne e : liste ){
				fichier.write(e.toString());
				fichier.newLine();
			}

			fichier.close();
		}catch(IOException e){
			System.out.println("Erreur :\n" + e);
		}
	}
}