package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import validation.GameMoneyValidation;

/**
 * Servlet implementation class GameMoney
 */
@WebServlet("/gameMoney")
public class GameMoneyServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public GameMoneyServlet() {
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
    String gameMoney = request.getParameter("gameMoney");


    try {
      GameMoneyValidation gameMoneyValidation = new GameMoneyValidation();
      gameMoneyValidation.gameMoneyValidate(gameMoney);
      request.getSession().setAttribute("gameMoney", gameMoney);
      response.sendRedirect("car.jsp");

    } catch (Exception e) {
      throw new ServletException(e);

    }

  }

}
