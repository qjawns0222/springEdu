package tommy.spring.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tommy.spring.web.impl.BoardDAO;
import tommy.spring.web.impl.BoardVO;
import tommy.spring.web.user.impl.UserDAO;
@Controller
public class LoginController {
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
		
		
	}
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(UserVO vo,UserDAO userdDAO,HttpSession session) {
		System.out.println("로그인 인증 처리");
		UserVO user=userdDAO.getUser(vo);
		if(vo.getId()==null||vo.getId().equals("")) {
			System.out.println("error");
			throw new NullPointerException("아이디는 반드시 혜성이어야 합니다.");
		}
		if (user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
		
	}
	
}
