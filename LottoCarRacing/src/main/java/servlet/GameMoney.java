package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import validation.GameMoneyValidation;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * Servlet implementation class GameMoney
 */
@WebServlet("/gameMoney")
public class GameMoney extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameMoney() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String gameMoney = request.getParameter("gameMoney");
		out.println("<h1>입력한:" + gameMoney);

		GameMoneyValidation gameMoneyValidation = new GameMoneyValidation();

		try {
			gameMoneyValidation.validate(gameMoney);
			request.getSession().setAttribute("gameMoney", gameMoney);
			response.sendRedirect("car.jsp");

		} catch (Exception e) {
			System.out.println("error ===>>>> " + e.getMessage());
			throw new ServletException(e);

		}

	}

}
