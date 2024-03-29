package fr.myapp.bus;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import Person.Person;
import exception.ExceptionPersonInvalidate;

public class PersonManager {

	private Map<Integer, Person> persons;

	public PersonManager() {
		persons = new HashMap<Integer,Person>();
		Person person1 =  null;
		for (int i = 0; i < 6; i++) {
			person1 = new Person();
			person1.setNom("te" + i);
			person1.setPrenom("e"+ i);
			person1.setDateNaissance(new Date());
			person1.setAdressMail("er@hort.fr" + i );
			persons.put(person1.getId(),person1);
		}
	}

	public Map<Integer, Person> getPersons() {
		return persons;
	}

	public Collection<Person> findAll() {
		return persons.values();
	}
	
	public Person getPerson(int i) {
		return persons.get(i);
	}

	public void save(Person p) {
		persons.put(p.getId(),p);
	}

	private boolean checkName(Person p) {
		return !p.getNom().isEmpty();
	}

	private boolean checkEmail(Person p) {
		String email = p.getAdressMail();
		InternetAddress interNet;
		try {
			interNet = new InternetAddress(email);
			interNet.validate();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}

	public void check(Person p) throws ExceptionPersonInvalidate {
		ExceptionPersonInvalidate e = new ExceptionPersonInvalidate();
		boolean name = checkName(p);
		if (!name)
			e.setNomValide("Nom invalide");
		boolean email = checkEmail(p);
		if(!email) {
			e.setEmailValide("Email invalide");
		}
		if (!name || ! email)
			throw e;
	}
	

}