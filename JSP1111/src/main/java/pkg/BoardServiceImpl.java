package pkg;

import java.util.List;

public class BoardServiceImpl implements BoardService {
	public BoardDao dao = null;
	
	@Override
	public void insert(BoardVO vo) {
		dao = new BoardDaoImpl();
		dao.insert(vo);
	}
	
	@Override
	public List<BoardVO> getBoardList() {
		return dao.getBoardLIst();
	}
}