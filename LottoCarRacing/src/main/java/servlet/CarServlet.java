package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Car;
import service.CarService;
import validation.CarValidation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class Car
 */
@WebServlet("/car")
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String carNames = request.getParameter("carNames");

		try {
			CarValidation carValidation = new CarValidation();
	   

		    CarService carService = new CarService();
			HttpSession session = request.getSession();

			String gameMoney = (String) session.getAttribute("gameMoney");
			
		    int amount = Integer.parseInt(gameMoney);
			
			List<String> cars = carValidation.carValidate(carNames, amount);
			List<Car> carInstance = carService.run(cars);
				    
		    session.setAttribute("carRacingResults", carInstance);
		    response.sendRedirect("racing.jsp");


		} catch (Exception e) {
			throw new ServletException(e);

		}

	}

}
