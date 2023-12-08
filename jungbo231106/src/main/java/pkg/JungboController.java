package pkg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JungboController
 */
public class JungboController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JungboController() {
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
		JungService service = new JungServiceImpl();
		JungVO vo = new JungVO();
		RequestDispatcher dispatcher = null;
		
		if(sw.equals("I")) {
			String sno = request.getParameter("sno");
			String sname = request.getParameter("sname");
			int kor = Integer.parseInt(request.getParameter("kor"));
			int eng = Integer.parseInt(request.getParameter("eng"));
			int math = Integer.parseInt(request.getParameter("math"));
			int hist = Integer.parseInt(request.getParameter("hist"));
			String today = request.getParameter("today");

			vo.setSno(sno);
			vo.setSname(sname);
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setMath(math);
			vo.setHist(hist);
			vo.setToday(today);
			
			service.insert(vo);
			
			dispatcher
				= request.getRequestDispatcher("JungboController?sw=S");
			dispatcher.forward(request, response);
		} else if(sw.equals("S")) {
			List<JungVO> li = service.select();
			//System.out.println(li.size());
			request.setAttribute("li", li);
			
			dispatcher
				= request.getRequestDispatcher("list.jsp");
			dispatcher.forward(request, response);
		} else if(sw.equals("F")) {
			int maxSno = service.maxSno();
			//System.out.println(maxSno);
			request.setAttribute("sno",  maxSno);
			
			dispatcher
				= request.getRequestDispatcher("form.jsp");
			dispatcher.forward(request, response);
		} else if(sw.equals("E")) {
			String sno = request.getParameter("sno");
			int snoInt = Integer.parseInt(sno);
			vo = service.selectSno(snoInt);
			service.cnt(sno);
			request.setAttribute("vo", vo);

			dispatcher
				= request.getRequestDispatcher("edit.jsp");
			dispatcher.forward(request, response);
		} else if(sw.equals("U")) {
			String sno = request.getParameter("sno");
			String sname = request.getParameter("sname");
			int kor = Integer.parseInt(request.getParameter("kor"));
			int eng = Integer.parseInt(request.getParameter("eng"));
			int math = Integer.parseInt(request.getParameter("math"));
			int hist = Integer.parseInt(request.getParameter("hist"));
			String today = request.getParameter("today");

			vo.setSno(sno);
			vo.setSname(sname);
			vo.setKor(kor);
			vo.setEng(eng);
			vo.setMath(math);
			vo.setHist(hist);
			vo.setToday(today);
			
			service.update(vo);
			
			dispatcher
			= request.getRequestDispatcher("JungboController?sw=S");
			dispatcher.forward(request, response);
		} else if(sw.equals("D")) {
			String sno = request.getParameter("sno");
			int snoInt = Integer.parseInt(sno);
			service.delete(snoInt);
			//request.setAttribute("vo", vo);

			dispatcher
				= request.getRequestDispatcher("JungboController?sw=S");
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
