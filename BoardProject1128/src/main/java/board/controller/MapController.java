package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MapController
 */
@WebServlet("/MapController")
public class MapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String sw = request.getParameter("sw");

		//집
		String latitude = "37.58608755";
		String longitude = "126.97686455";
		if(sw.equals("S1")) {
			request.setAttribute("latitude", latitude);
			request.setAttribute("longitude", longitude);
			
			RequestDispatcher dispatcher
		      	= request.getRequestDispatcher("/map/map1.jsp");
			dispatcher.forward(request, response);
		} else if (sw.equals("S2")) {
			request.setAttribute("latitude", latitude);
			request.setAttribute("longitude", longitude);
			
			RequestDispatcher dispatcher
	      		= request.getRequestDispatcher("/map/map2.jsp");		
			dispatcher.forward(request, response);			
		} else if (sw.equals("S3")) {
			String address = "서울 관악구 남부순환로 지하 1614";
			String company = "신림역";
			request.setAttribute("address", address);
			request.setAttribute("company", company);
			
			RequestDispatcher dispatcher
      			= request.getRequestDispatcher("/map/map3.jsp");
			dispatcher.forward(request, response);
		} else if (sw.equals("K1")) {
			request.setAttribute("latitude", latitude);
			request.setAttribute("longitude", longitude);
			
			RequestDispatcher dispatcher
		      	= request.getRequestDispatcher("/map/map1.jsp");
			dispatcher.forward(request, response);			
		} else if (sw.equals("K2")) {
			latitude = "37.48546805";
			longitude = "126.9302654";
			request.setAttribute("latitude", latitude);
			request.setAttribute("longitude", longitude);
			
			RequestDispatcher dispatcher
		      	= request.getRequestDispatcher("/map/map1.jsp");
			dispatcher.forward(request, response);
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
