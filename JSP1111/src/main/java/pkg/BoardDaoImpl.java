package pkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class BoardDaoImpl implements BoardDao   {

	public Connection	conn = null;
	public PreparedStatement pstmt = null ;
	public ResultSet rs = null;

	@Override
	public void insert(BoardVO vo) {
		try {
			conn  = DBConnection.getConnection();
			
			String SQL = "insert into T1102(idx, name, age) values(ST1102.nextval, ?, ?) ";
			pstmt = conn.prepareStatement(SQL);
			//pstmt.setInt(1, vo.getIdx());
			pstmt.setString(2, vo.getName());			
			pstmt.setInt(3, vo.getAge());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public List<BoardVO> getBoardLIst() {
		List<BoardVO> li = null;
		try {			
			conn = DBConnection.getConnection();
			String SQL = "SELECT * FROM T1102";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			BoardVO m = null;
			while(rs.next()) {
				m=new BoardVO();
				m.setIdx(rs.getInt("idx"));
				m.setName(rs.getString("name"));
				m.setAge(rs.getInt("age"));
				li.add(m);
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;		
	}

}