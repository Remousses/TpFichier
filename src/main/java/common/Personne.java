package common;

public class Personne implements Comparable{
	private String nom;
	private String prenom;
	private Adresse adresse;
	private String tel;
	
	public Personne(String nom,String prenom){
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = new Adresse();
		this.tel = "";
	}
	
	public Personne(String nom,String prenom, Adresse adresse, String tel){
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String toString() {
		return nom + ";" + prenom + ";" + adresse.toString() + ";" + tel;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
}
