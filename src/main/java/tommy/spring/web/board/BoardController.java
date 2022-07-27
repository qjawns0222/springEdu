package tommy.spring.web.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import tommy.spring.web.impl.BoardDAO;
import tommy.spring.web.impl.BoardVO;

@SessionAttributes("board")
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		return conditionMap;
	}

	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public BoardListVO dataTransForm(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardList(boardList);
		return boardListVO;
	}

	@RequestMapping("/dataTransform1.do")
	@ResponseBody
	public List<BoardVO> dataTransForm1(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		return boardList;
	}

	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model, @RequestHeader("Accept-Language") String languageHeader) {
		System.out.println("�� ��� �˻� ó�� ���Ҳ���");
		if (vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		if (vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		System.out.println("����׽�Ʈ:" + languageHeader);
		System.out.println("�˻�����:" + vo.getSearchCondition());
		System.out.println("�˻��ܾ�:" + vo.getSearchKeyword());
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}

	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model, HttpServletResponse response) {
		System.out.println("�� �� ���� ó��");
		// response.addCookie(new Cookie("auth", "1"));
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard.jsp";
	}

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("�ۻ��� ó��");
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		System.out.println("�۵�� ó��");
		// request.setCharacterEncoding("UTF-8");
		MultipartFile uploadFile = vo.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/MyProject/image/" + fileName));
		}

		boardService.insertBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo,
			@CookieValue(value = "auth", defaultValue = "0") String auth) {
		System.out.println("�� ���� ó��");
		System.out.println("auth:" + auth);
		System.out.println("��ȣ:" + vo.getSeq());
		System.out.println("����:" + vo.getTitle());
		System.out.println("�ۼ���:" + vo.getWriter());
		System.out.println("����:" + vo.getContent());
		System.out.println("�����:" + vo.getRegDate());
		System.out.println("��ȸ��:" + vo.getCnt());
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
}
