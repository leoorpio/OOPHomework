package guitarsearch.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guitarsearch.dao.InventoryDao;
import guitarsearch.daoImpl.InventoryDaoImpl;
import guitarsearch.domain.Builder;
import guitarsearch.domain.Guitar;
import guitarsearch.domain.GuitarSpec;
import guitarsearch.domain.Type;
import guitarsearch.domain.Wood;


/**
 * Servlet implementation class SearchGuitar
 */
@WebServlet("/SearchGuitar")
public class SearchGuitarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGuitarAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Builder builder = Builder.valueOf(request.getParameter("bulider"));
		Type type= Type.valueOf(request.getParameter("type"));
		Wood topWood = Wood.valueOf(request.getParameter("topWood"));
		Wood backWood = Wood.valueOf(request.getParameter("backWood"));		
		String model = request.getParameter("model");
		String strings = request.getParameter("numStrings");
		int numStrings = Integer.parseInt(strings);
		GuitarSpec spec = new GuitarSpec(builder, model, type, numStrings, backWood, topWood);
		InventoryDao inve = new InventoryDaoImpl();
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
