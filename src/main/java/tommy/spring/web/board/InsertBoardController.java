package tommy.spring.web.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import tommy.spring.web.impl.BoardDAO;
import tommy.spring.web.impl.BoardVO;

public class InsertBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글등록 처리");
		 //request.setCharacterEncoding("UTF-8");
		    String title=request.getParameter("title");
		    String writer=request.getParameter("writer");
		    String content=request.getParameter("content");
		    BoardVO vo= new BoardVO();
		    vo.setTitle(title);
		    vo.setWriter(writer);
		    vo.setContent(content);
		    
		    BoardDAO boardDAO=new BoardDAO();
		    boardDAO.insertBoard(vo);
		    ModelAndView mav=new ModelAndView();
			mav.setViewName("redirect:getBoardList.do");
			return mav;
		 
		
		
	}

}
