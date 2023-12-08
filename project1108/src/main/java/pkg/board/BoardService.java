package pkg.board;

import java.util.List;

public interface BoardService {
	void insert(BoardVO vo);
	List<BoardVO> select(BoardVO vo);
	BoardVO selectNumid(int numId);
}