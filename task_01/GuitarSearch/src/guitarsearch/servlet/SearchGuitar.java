package guitarsearch.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guitarsearch.daoImpl.InventoryDaoImpl;
import guitarsearch.domain.Guitar;

/**
 * Servlet implementation class SearchGuitar
 */
@WebServlet("/SearchGuitar")
public class SearchGuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGuitar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/x-json");
//		PrintWriter pw = response.getWriter();

		Guitar searchGuitar = new Guitar();
		
		searchGuitar.setBuilder(request.getParameter("builder"));
		searchGuitar.setModel(request.getParameter("model"));
		searchGuitar.setType(request.getParameter("type"));
		searchGuitar.setBackWood(request.getParameter("backWood"));
		searchGuitar.setTopWood(request.getParameter("topWood"));		
		InventoryDaoImpl inventory = new InventoryDaoImpl();
		inventory.getAllGuitars();
	}

}

/*
 * { "success": true, 
 * "rows": [{"serialNumber": 1, "price": 2222.22, "builder": "Collings",
 * 			"model": "CJ", "type": "acoustic", "backWood": "Indian Rosewood", "topWood": "Sitka"},
 */