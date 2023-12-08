package pkg.board;

import java.util.List;

public class BoardServiceImpl implements BoardService {
	BoardDao dao = new BoardDaoImpl();
	
	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
	}

	@Override
	public List<BoardVO> select(BoardVO vo) {		
		return dao.select(vo);
	}

	@Override
	public BoardVO selectNumid(int numId) {
		return dao.selectNumid(numId);
	}
}