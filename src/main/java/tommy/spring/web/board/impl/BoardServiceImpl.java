package tommy.spring.web.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tommy.spring.web.board.BoardService;
import tommy.spring.web.impl.BoardDAO;
import tommy.spring.web.impl.BoardVO;
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	@Override
	public void insertBoard(BoardVO vo) {
		System.out.println(vo.getSeq());
		if(vo.getSeq()==0) {
			throw new IllegalArgumentException("0번 글을 등록 할 수 없습니다.");
		}
		boardDAO.insertBoard(vo);
		
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
		
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
		
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.getBoardList(vo);
	}

}
