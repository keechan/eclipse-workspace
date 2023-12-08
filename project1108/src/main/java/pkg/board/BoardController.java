package pkg.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String contextPath = request.getContextPath();
		String sw = request.getParameter("sw");
		
		RequestDispatcher dispatcher = null;
		BoardService service = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		
		if (sw.equals("S")) {
			String ch1 = request.getParameter("ch1");
			String ch2 = request.getParameter("ch2");
			
			vo.setCh1(ch1);
			vo.setCh2(ch2);
			
			List<BoardVO> li = service.select(vo);
			request.setAttribute("li", li);
			String path="/board/board_list.jsp";
			
			dispatcher = request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} else if (sw.equals("I")) {
			System.out.println("==> I(Board Start)");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			vo.setTitle(title);
			vo.setContent(content);
			service.insert(vo);
			System.out.println("==> I(Board End)");
			dispatcher
				= request.getRequestDispatcher("BoardController?sw=S");
			dispatcher.forward(request, response);
		
			//response.sendRedirect("index.jsp");
		} else if (sw.equals("E")) {
			System.out.println("==> E(BoardController)Start");
			
			int numId = Integer.parseInt(request.getParameter("numId"));
			vo = service.selectNumid(numId);
			
			request.setAttribute("vo", vo);
			
			dispatcher
				= request.getRequestDispatcher("/board/board_edit.jsp");
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
