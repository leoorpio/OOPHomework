package guitarsearch.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import guitarsearch.domain.Guitar;
import guitarsearch.domain.GuitarSpec;

/**
 * Servlet implementation class Results
 */
@WebServlet("/Results")
public class Results extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Results() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset = utf-8");
		@SuppressWarnings("unchecked")
		List<Guitar> guitars = (List<Guitar>) request.getAttribute("guitars");
		PrintWriter pw = response.getWriter();
		
		String j = "{\"success\": true, \"row\": [";
		
		
		for(Guitar guitar: guitars) {
			GuitarSpec spec = guitar.getSpec();
			j += "{";
			j += "\"serialNumber\":\"" + guitar.getSerialNumber() + "\", ";
			j += "\"builder\":\"" + spec.getBuilder() + "\", ";
			j += "\"model\":\"" + spec.getModel() + "\", ";
			j += "\"stringNumber\":\"" + spec.getNumStrings() + "\", ";
			j += "\"type\":\"" + spec.getType() +"\", ";
			j += "\"backWood\":\"" + spec.getBackWood() + "\", ";
			j += "\"topWood\":\"" + spec.getTopWood() + "\", ";
			j += "\"price\":" + guitar.getPrice() + "}";
			j += ", ";
		}
		
		if (j != "{\"success\": true, \"row\": [") {
			j = j.substring(0, j.length() - 2);
			j += "]}";
		} else {
			j = "{\"success\": false, \"row\": [{\"Tips\": \"老板，没有查询到符合的信息！\"}]}";
		}
		pw.print(j);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
