package tommy.spring.web.board.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import tommy.spring.collection.BoardVO;
import tommy.spring.web.common.JDBCUtil;

@Repository
public class BoardDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String BOARD_INSERT="insert into myboard(seq,title,writer,content) values((select nvl(max(seq),0)+1 from myboard),?,?,?)";
	//private final String BOARD_INSERT="insert into myboard(seq,title,writer,content) values(?,?,?,?)";
	private final String BOARD_UPDATE="update myboard set title=?.content=? where seq=?";
	private final String BOARD_DELETE="delete myboard where seq=?";
	private final String BOARD_GET="select * from myboard where seq=?";
	private final String BOARD_LIST="select * from myboard order by seq desc";
	public void insertBoard(BoardVO vo) {
		System.out.println("JDBC�� insertBoard()��� ó��");
		jdbcTemplate.update(BOARD_INSERT,vo.getTitle(),vo.getWriter(),vo.getContent());
		//jdbcTemplate.update(BOARD_INSERT,vo.getSeq(),vo.getTitle(),vo.getWriter(),vo.getContent());
	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("JDBC�� deleteBoard()��� ó��");
		jdbcTemplate.update(BOARD_DELETE,vo.getSeq());
	}
	public void updateBoard(BoardVO vo) {
		System.out.println("JDBC�� updateBoard()��� ó��");
		jdbcTemplate.update(BOARD_UPDATE,vo.getTitle(),vo.getContent(),vo.getSeq());
	}
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("JDBC�� getBoard()��� ó��");
		Object[] args= {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET,new BoardRowMapper(),args);
			
		
	}
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("JDBC�� getBoardList()��� ó��");
		
		return jdbcTemplate.query(BOARD_LIST,new BoardRowMapper());
	}
	@Override
	public String toString() {
		return "BoardDAOSpring [jdbcTemplate=" + jdbcTemplate + ", BOARD_INSERT=" + BOARD_INSERT + ", BOARD_UPDATE="
				+ BOARD_UPDATE + ", BOARD_DELETE=" + BOARD_DELETE + ", BOARD_GET=" + BOARD_GET + ", BOARD_LIST="
				+ BOARD_LIST + "]";
	}
	
	

}
