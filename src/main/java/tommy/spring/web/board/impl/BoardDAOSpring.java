package tommy.spring.web.board.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import tommy.spring.web.common.JDBCUtil;
import tommy.spring.web.impl.BoardVO;

@Repository
public class BoardDAOSpring {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String BOARD_INSERT="insert into myboard(seq,title,writer,content) values((select nvl(max(seq),0)+1 from myboard),?,?,?)"; // 
	//private final String BOARD_INSERT="insert into myboard(seq,title,writer,content) values(?,?,?,?)";
	private final String BOARD_UPDATE = "update myboard set title=?.content=? where seq=?";
	private final String BOARD_DELETE = "delete myboard where seq=?";
	private final String BOARD_GET = "select  from myboard where seq=?";
	private final String BOARD_LIST = "select  from myboard order by seq desc";
	private final String BOARD_LIST_T="select * from myboard where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_C="select * from myboard where content like '%'||?||'%' order by seq desc";
	public void insertBoard(BoardVO vo) { 
		System.out.println("JDBC로 insertBoard()기능 처리");
		jdbcTemplate.update(BOARD_INSERT,vo.getTitle(),vo.getWriter(),vo.getContent());
  //jdbcTemplate.update(BOARD_INSERT,vo.getSeq(),vo.getTitle(),vo.getWriter(),vo.getContent()); 
  }

	public void deleteBoard(BoardVO vo) {
		System.out.println("JDBC로 deleteBoard()기능 처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("JDBC로 updateBoard()기능 처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("JDBC로 getBoard()기능 처리");
		Object[] args = { vo.getSeq() };
		return jdbcTemplate.queryForObject(BOARD_GET, new BoardRowMapper(), args);

	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("JDBC로 getBoardList()기능 처리");
		Object[] args= {vo.getSearchKeyword()};
		if(vo.getSearchCondition().equals("TITLE")) {
			return jdbcTemplate.query(BOARD_LIST_T, new BoardRowMapper(),args);
		}else if(vo.getSearchCondition().equals("CONTENT")) {
			return jdbcTemplate.query(BOARD_LIST_C, new BoardRowMapper(),args);
		}
		return null;
		
	}

	@Override
	public String toString() {
		return "BoardDAOSpring [jdbcTemplate=" + jdbcTemplate + ", BOARD_INSERT=" + BOARD_INSERT + ", BOARD_UPDATE="
				+ BOARD_UPDATE + ", BOARD_DELETE=" + BOARD_DELETE + ", BOARD_GET=" + BOARD_GET + ", BOARD_LIST="
				+ BOARD_LIST + "]";
	}

}
