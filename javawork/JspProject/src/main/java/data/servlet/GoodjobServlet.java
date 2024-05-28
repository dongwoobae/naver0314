package data.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoodjobServlet
 */
@WebServlet("/study4")
public class GoodjobServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> list1= Arrays.asList("orange","green","pink","gray","magenta","tomato");
		request.setAttribute("list1", list1);
		//문자열 저장
		request.setAttribute("flowers", "장미꽃,안개꽃,다알리아,프리지아,국화,채송화,호박꽃,밤꽃");
		RequestDispatcher rd = request.getRequestDispatcher("./day0513/test4.jsp");//forward 할 곳 지정
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
