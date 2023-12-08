package pkg;

import java.util.List;

public interface BoardService {
	public void insert(BoardVO vo);
	public List<BoardVO> getBoardList();
}