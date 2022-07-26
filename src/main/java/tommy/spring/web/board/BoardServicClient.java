package tommy.spring.web.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import tommy.spring.web.impl.BoardVO;







public class BoardServicClient {
	public static void main(String[] args) {
		AbstractApplicationContext container=new GenericXmlApplicationContext("applicationContext.xml");
		BoardService boardService=(BoardService)container.getBean("boardService");
		BoardVO vo= new BoardVO();
		//vo.setSeq(1000);
		vo.setTitle("임시제목");
		vo.setWriter("홍길동");
		vo.setContent("일빠...");
		boardService.insertBoard(vo);
		List<BoardVO> boardList=boardService.getBoardList(vo);
		for(BoardVO board:boardList) {
			System.out.println("----->"+board.toString());
		}
		container.close();
	}

}
