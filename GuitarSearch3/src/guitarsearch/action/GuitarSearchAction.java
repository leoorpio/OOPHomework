package guitarsearch.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guitarsearch.dao.InventoryDao;
import guitarsearch.domain.Builder;
import guitarsearch.domain.DataAccess;
import guitarsearch.domain.Guitar;
import guitarsearch.domain.GuitarSpec;

/**
 * Servlet implementation class GuitarSearchAction
 */
@WebServlet("/GuitarSearch")
public class GuitarSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuitarSearchAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Builder builder = Builder.valueOf(request.getParameter("bulider"));
		
		GuitarSpec spec = new GuitarSpec();
		spec.setBuilder(builder);
		
		InventoryDao inve = DataAccess.createInventoryDao();
		List<Guitar> guitars = inve.searchGuitar(spec);
		if(! guitars.isEmpty()) {
			request.setAttribute("guitars", guitars);
			request.getRequestDispatcher("Results").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
