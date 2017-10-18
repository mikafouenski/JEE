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


@WebServlet(name = "edition", urlPatterns = { "/edition" })
public class Edition extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PersonManager getPersonManager(HttpServletRequest request) {
		Object o_m = request.getServletContext().getAttribute("manager");
		if (o_m instanceof PersonManager)
			return (PersonManager) o_m;
		return new PersonManager();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String firstname = request.getParameter("firstname");
		String birthdate = request.getParameter("birthdate");
		String mail = request.getParameter("mail");

		Person p = null;
		Object o_p = request.getSession().getAttribute("p");
		if (o_p instanceof Person) {
			p = (Person) o_p;
		} else {
			p = new Person();
			System.out.println("Create a Person");
		}

		p.setName(name);
		p.setFirstname(firstname);
		try {
			p.setBirthdate(new SimpleDateFormat().parse(birthdate));
		} catch (ParseException e) {
			System.out.println("Date echec !");
		}
		p.setMail(mail);

		PersonManager manager = getPersonManager(request);
		ValidatorPerson vP = manager.check(p);

		request.setAttribute("p", p);
		if (vP.hasError()) {
			if (!vP.getEmailError().isEmpty())
				request.setAttribute("emailError", vP.getEmailError());
			if (!vP.getNameError().isEmpty())
				request.setAttribute("nameError", vP.getNameError());
			request.getRequestDispatcher("edition.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("person.jsp").forward(request, response);
		}
	}

}
