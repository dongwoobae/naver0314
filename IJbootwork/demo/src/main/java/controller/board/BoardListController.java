package controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import data.dto.ReBoardDto;
import data.service.ReBoardService;


@Controller
public class BoardListController {
	@Autowired
	private ReBoardService boardService;

	@GetMapping("/board/list")
	public String list(
			@RequestParam(defaultValue = "1") int currentPage,
			Model model
			) {
		//총 글의 개수
		int totalCount = boardService.getTotalCount();
		//페이징에 필요한 변수들
		int perPage=5;//한페이지 당 보여질 글의 개수 (바뀔 수 있어서 변수로 지정)
		int perBlock=5;//현재 블럭에 보여질 페이지의 개수
		int start;//db 에서 가져올 시작번호
		int startPage;//각 블럭에 보여질 시작페이지
		int totalPage;//총 페이지수
		int endPage;//각 블럭에 보여질 끝페이지
		int no;//각 페이지에 보여질 시작번호 

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

		//각 페이지에 출력할 시작번호
		no=totalCount-(currentPage-1)*perPage;
		
		//목록 가져오기
		List<ReBoardDto> list = boardService.getPagingList(perPage, start);
		//model에 필요한 data 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		model.addAttribute("perBlock", perBlock);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("no", no);
		
		return "board/boardlist";
	}

}
