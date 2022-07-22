package tommy.spring.web.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import tommy.spring.web.impl.BoardDAO;
import tommy.spring.web.impl.BoardVO;

public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글삭제 처리");
		String seq=request.getParameter("seq");
		System.out.println(seq);
		BoardVO vo=new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		BoardDAO boardDAO=new BoardDAO();
		boardDAO.deleteBoard(vo);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		return mav;
		
		
		
	}

}
