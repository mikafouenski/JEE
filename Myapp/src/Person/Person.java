package Person;
import java.util.Date;
public class Person {
	
	private int id = 0;
	private String nom = "defaultName";
	private String prenom = "defaultPrenom";
	private Date dateNaissance = new Date(); 
	private String adressMail = "DefaultAdresseMail";
	private static int cpt = 0;
	
	public Person(){
		setId(cpt);
		++cpt;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getAdressMail() {
		return adressMail;
	}
	public void setAdressMail(String adressMail) {
		this.adressMail = adressMail;
	}
	
	
}
