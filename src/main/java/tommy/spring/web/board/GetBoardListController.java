package tommy.spring.web.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import tommy.spring.web.impl.BoardDAO;
import tommy.spring.web.impl.BoardVO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("�� ��� �˻� ó��");
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		HttpSession session=request.getSession();
		session.setAttribute("boardList", boardList);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("getBoardList");
		return mav;
	}

}
