package servlet;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Car;
import model.CarValidationResult;
import service.CarService;
import service.RacingService;
import validation.CarValidation;

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
	@Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain; charset=UTF-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");



		try {
			CarValidation carValidation = new CarValidation();


		    CarService carService = new CarService();
		    RacingService racingService = new RacingService();
			HttpSession session = request.getSession();

			String gameMoney = (String) session.getAttribute("gameMoney");
		    String carNames = request.getParameter("carNames");
		    String topRanksCarNames = request.getParameter("topRanksCarNames");


		    int amount = Integer.parseInt(gameMoney);

		    CarValidationResult result  = carValidation.carValidate(carNames, topRanksCarNames, amount);
		     
		    List<String> cars = result.getCarList();
		    List<String> topRanksCars = result.getTopRanksCarList();
			List<Car> carInstance = carService.run(cars);
			List<String> rankCars = carService.runTopRanksCars(carInstance, topRanksCars);

		    session.setAttribute("carRacingResults", carInstance);
		    session.setAttribute("rankCars",  rankCars);
		
		    response.sendRedirect("racing.jsp");


		} catch (Exception e) {
			throw new ServletException(e);

		}

	}

}
