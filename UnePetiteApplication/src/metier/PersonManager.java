package metier;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import beans.Person;

public class PersonManager {

	final private Map<Integer, Person> persons;

	public PersonManager() {
		persons = new HashMap<Integer, Person>();
		for (int i = 0; i < 10; i++) {
			Person p = new Person();
			p.setName("n" + i);
			p.setFirstname("f" + i);
			p.setBirthdate(new Date());
			p.setMail("m" + i);
		}
	}

	public Collection<Person> findAll() {
		return persons.values();
	}

	public void save(Person p) {
		persons.put(p.getId(), p);
	}

	public ValidatorPerson check(Person p) {
		ValidatorPerson v = new ValidatorPerson();
		if (p.getName().isEmpty()) {
			v.setError(true);
			v.setNameError("Name cannot be empty !");
		}

		try {
			InternetAddress emailAddr = new InternetAddress(p.getMail());
			emailAddr.validate();
		} catch (AddressException e) {
			v.setError(true);
			v.setEmailError("Email not valid");
		}

		return v;
	}

}
