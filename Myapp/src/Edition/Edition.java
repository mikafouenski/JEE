package Edition;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Person.Person;
import exception.ExceptionPersonInvalidate;
import fr.myapp.bus.PersonManager;

/**
 * Servlet implementation class Edition
 */
@WebServlet("/edition")
public class Edition extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Edition() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private PersonManager getPerM(HttpServletRequest request) {
		Object o_perM = request.getServletContext().getAttribute("perM");
		PersonManager perM = null;
		if (o_perM instanceof PersonManager) perM = (PersonManager) o_perM;
		if (perM == null) {
			perM = new PersonManager();
			request.getServletContext().setAttribute("perM", perM);
		}
		return perM;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num_str = request.getParameter("numero");
		Person p;
		PersonManager perM = getPerM(request);
		if (num_str != null) {
			int num = Integer.parseInt(num_str);
			p = perM.getPerson(num);
		} else {
			p = new Person();
		}

		request.setAttribute("person", p);
		request.getRequestDispatcher("edition.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("mail");
		String date = request.getParameter("date");
		Object o = request.getSession().getAttribute("person");

		Person p = null;
		if (o instanceof Person) {
			p = (Person) o;
		} else {
			p = new Person();
		}
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setAdressMail(email);
		PersonManager perM = getPerM(request);
		try {
			perM.check(p);
			request.setAttribute("person", p);
			request.getRequestDispatcher("person.jsp").forward(request, response);
			perM.save(p);
		} catch (ExceptionPersonInvalidate e) {
			request.setAttribute("excep", e);
			request.setAttribute("person", p);
			request.getRequestDispatcher("edition.jsp").forward(request, response);
		}
	}

}
