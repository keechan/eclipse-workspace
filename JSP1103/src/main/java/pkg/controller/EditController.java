package pkg.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pkg.Service.MemberService;
import pkg.Service.MemberServiceImpl;
import pkg.model.MemberVO;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class EditController
 */
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = request.getParameter("id");
		
		MemberService service = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(id);
		MemberVO m = service.edit(vo);
		
		//System.out.println(m.toString());
		
		//request에 값을 저장함, 세션 값과 같은 값을 저장할 때 등....
		request.setAttribute("m", m);
		
		//리다이렉트
		RequestDispatcher dispatcher 
			= request.getRequestDispatcher("/member/member_edit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
