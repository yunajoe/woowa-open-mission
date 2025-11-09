package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.CarService;
import validation.CarValidation;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Car
 */
@WebServlet("/car")
public class Car extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain; charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.println("Hello, CarServlet!입니당 ");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String carNames = request.getParameter("carNames");
		PrintWriter out = response.getWriter();
		out.println("<h1>입력한 값:" + carNames);

		try {
			CarValidation carValidation = new CarValidation();
			HttpSession session = request.getSession();

			String gameMoney = (String) session.getAttribute("gameMoney");
			
		    int amount = Integer.parseInt(gameMoney);
			
			carValidation.carValidate(carNames, amount);
		    response.sendRedirect("racing.jsp");


		} catch (Exception e) {
			throw new ServletException(e);

		}

	}

}
