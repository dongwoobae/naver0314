package board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.SimpleBoardDao;
import data.dto.SimpleBoardDto;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	SimpleBoardDao dao = new SimpleBoardDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 총개수
		int totalCount = dao.getTotalCount();
		//페이징에 필요한 목록 가져오기
		List<SimpleBoardDto> list=null;
		
		//페이징에 필요한 변수들
		int perPage=5;//한페이지 당 보여질 글의 개수 (바뀔 수 있어서 변수로 지정)
		int perBlock=3;//현재 블럭에 보여질 페이지의 개수
		int start;//db 에서 가져올 시작번호
		int startPage;//각 블럭에 보여질 시작페이지
		int totalPage;//총 페이지수
		int endPage;//각 블럭에 보여질 끝페이지
		int currentPage;//현재 페이지
		int no;//각 페이지에 보여질 시작번호 
		
		//현재 페이지를 읽어오는데 null일 경우 1로 지정(열자마자는 null이 옴)
		if(request.getParameter("currentPage")==null) {
			currentPage=1;
		} else {
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		//총 페이지 수 구하기
		totalPage = totalCount/perPage +(totalCount%perPage>=1?1:0);
		//각 블럭당 시작 페이지 구하기
		startPage=(currentPage-1)/perBlock*perBlock+1;
		endPage=startPage+perBlock-1;
		//endPage가 총 페이지 수가 총 페이지 수보다 커서는 안된다
		if(endPage>totalPage) {
			endPage=totalPage;
		}
		//db에서 가져올 글의 시작번호
		//예: 1페이지:0~ , 2페이지: 5~
		start=(currentPage-1)*perPage;
		list=dao.getAllDatas(start, perPage);//일단 10개만 가져오기
		
		//각 페이지에 출력할 시작번호
		no=totalCount-(currentPage-1)*perPage;
		
		//request에 저장
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("list", list);
		//페이지 출력시 필요한 변수들을 모두 request에 저장
		request.setAttribute("perBlock", perBlock);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startPage",startPage);
		request.setAttribute("endPage",endPage);
		request.setAttribute("totalPage",totalPage);
		request.setAttribute("no", no);
		
		RequestDispatcher rd = request.getRequestDispatcher("../day0514/boardlist.jsp");
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
