package Edition;

import java.io.IOException;
import java.sql.Date;

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
@WebServlet("/Edition")
public class Edition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edition() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("mail");
		String date = request.getParameter("date");
		Person p = (Person) request.getAttribute("per");
		
		
		if(p == null)
			p = new Person();
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setAdressMail(email);	
		PersonManager perM = new PersonManager();
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
