package servelet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Person;
import metier.PersonManager;
import metier.ValidatorPerson;

@WebServlet(name = "edition", urlPatterns = { "/edition", "/supprimer" })
public class Edition extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PersonManager getPersonManager(HttpServletRequest request) {
		Object o_m = request.getServletContext().getAttribute("manager");
		if (o_m instanceof PersonManager)
			return (PersonManager) o_m;
		PersonManager manager = new PersonManager();
		request.getServletContext().setAttribute("manager", manager);
		return manager;
	}

	private void exectueAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("edition.jsp").forward(request, response);
	}
	
	private void executeEdit(HttpServletRequest request, HttpServletResponse response, Person p) throws ServletException, IOException {
		request.setAttribute("p", p);
		request.getRequestDispatcher("edition.jsp").forward(request, response);
	}
	
	private void executeDelete(HttpServletRequest request, HttpServletResponse response, Person p) throws ServletException, IOException {
		getPersonManager(request).getPersons().remove(p).getId();
		request.getRequestDispatcher("lister.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num_str = request.getParameter("numero");
		System.out.println(num_str);
		if (num_str == null) {
			exectueAdd(request, response);
			return;
		}
		int num;
		try {
			num = Integer.parseInt(num_str);
		} catch (Exception e) {
			System.out.println("Erreur num =" + num_str);
			e.printStackTrace();
			exectueAdd(request, response);
			return;
		}
		Person p = getPersonManager(request).getPerson(num);
		if (p == null) {
			System.out.println("p est null");
			getPersonManager(request).display();
			exectueAdd(request, response);
			return;
		}
		executeEdit(request, response, p);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String firstname = request.getParameter("firstname");
		String birthdate = request.getParameter("birthdate");
		String mail = request.getParameter("mail");

		Person p = null;
		Object o_p = request.getAttribute("p");
		if (o_p instanceof Person) {
			p = (Person) o_p;
		} else {
			p = new Person();
			System.out.println("Create a Person");
		}

		p.setName(name);
		p.setFirstname(firstname);
		p.setMail(mail);
		try {
			p.setBirthdate(new SimpleDateFormat().parse(birthdate));
		} catch (ParseException e) {
			System.out.println("Date echec !");
		}

		PersonManager manager = getPersonManager(request);
		ValidatorPerson vP = manager.check(p);

		if (vP.hasError()) {
			if (!vP.getEmailError().isEmpty())
				request.setAttribute("emailError", vP.getEmailError());
			if (!vP.getNameError().isEmpty())
				request.setAttribute("nameError", vP.getNameError());
			executeEdit(request, response, p);
		} else {
			manager.save(p);
			request.setAttribute("p", p);
			request.getRequestDispatcher("person.jsp").forward(request, response);
		}
	}

}
