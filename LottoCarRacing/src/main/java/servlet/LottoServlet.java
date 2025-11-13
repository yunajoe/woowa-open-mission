package servlet;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.LottoNumber;
import model.RankCar;
import service.LottoService;
import validation.LottoValidation;

/**
 * Servlet implementation class LottoServlet
 */
@WebServlet("/lotto")
public class LottoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public LottoServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

    try {
      LottoValidation lottoValidation = new LottoValidation();
      LottoService lottoService = new LottoService();
      HttpSession session = request.getSession();

      String[] numbers = {request.getParameter("num1"), request.getParameter("num2"),
          request.getParameter("num3"), request.getParameter("num4"), request.getParameter("num5"),
          request.getParameter("num6")};
      String bonusNumber = request.getParameter("bonusNum");

      LottoNumber lottoNumber = lottoValidation.lottoValidate(numbers, bonusNumber);

      List<RankCar> rankCars = (List<RankCar>) session.getAttribute("rankCars");

      lottoService.run(rankCars);
      lottoService.winningLotto(rankCars, lottoNumber);
      
      
      request.setAttribute("rankCars", rankCars);
      request.getRequestDispatcher("result.jsp").forward(request, response);




    } catch (Exception e) {
      throw new ServletException(e);

    }



  }

}
