package beans;

import java.util.Date;

public class Person {
	
	private static int PersonId = 0;

	private int id;
	private String name = "name";
	private String firstname = "firstname";
	private Date birthdate = new Date();
	private String mail = "mail";
	
	
	public Person() {
		this.id = PersonId;
		PersonId++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", firstname=" + firstname + ", birthdate=" + birthdate
				+ ", mail=" + mail + "]";
	}

}
