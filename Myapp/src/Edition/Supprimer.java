package Edition;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Person.Person;
import fr.myapp.bus.PersonManager;

/**
 * Servlet implementation class Supprimer
 */
@WebServlet("/supprimer")
public class Supprimer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Supprimer() {
		super();
		// TODO Auto-generated constructor stub
	}

	private PersonManager getPerM(HttpServletRequest request) {
		Object o_perM = request.getServletContext().getAttribute("perM");
		PersonManager perM = null;
		if (o_perM instanceof PersonManager)
			perM = (PersonManager) o_perM;
		if (perM == null) {
			perM = new PersonManager();
			request.getServletContext().setAttribute("perM", perM);
		}
		return perM;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num_str = request.getParameter("numero");
		Person p;
		if (num_str != null) {
			int num = Integer.parseInt(num_str);
			PersonManager perM = getPerM(request);
			p = perM.getPerson(num);
			if (p != null) {
				perM.getPersons().remove(p.getId());
			}
		}
		request.getRequestDispatcher("lister.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
