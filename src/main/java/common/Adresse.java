package common;

public class Adresse {
	private String rue;
	private String codePostal;
	private String ville;
	
	public Adresse() {
		this.rue = "";
		this.codePostal = "";
		this.ville = "";
	}
	
	public Adresse(String rue, String codePostal, String ville) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String toString() {
		if( this.rue == ""){
			return codePostal + "," + ville;
		}else if(this.codePostal == ""){
			return rue + "," + ville;
		}else if(this.ville == ""){
			return rue + "," + codePostal;
		}else{
			return rue + "," + codePostal + "," + ville;
		}
	}
	
	
}
