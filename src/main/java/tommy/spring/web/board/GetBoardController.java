package tommy.spring.web.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import tommy.spring.web.impl.BoardDAO;
import tommy.spring.web.impl.BoardVO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� �� ���� ó��");
		   String seq=request.getParameter("seq");
		    BoardVO vo=new BoardVO();
		    vo.setSeq(Integer.parseInt(seq));
		    BoardDAO boardDAO=new BoardDAO();
		    BoardVO board=boardDAO.getBoard(vo);
		    HttpSession session=request.getSession();
			session.setAttribute("board", board);
			ModelAndView mav=new ModelAndView();
			mav.setViewName("getBoard");
		return mav;
	}

}
