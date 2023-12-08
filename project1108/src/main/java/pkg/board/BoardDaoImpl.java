package pkg.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pkg.DBConnection;

public class BoardDaoImpl implements BoardDao {
	DBConnection dbConn = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public BoardDaoImpl() {
		dbConn = DBConnection.getInstance();
	}
	
	@Override
	public void insert(BoardVO vo) {
		try {
			//System.out.println("=======> BoardDaoImpl(Start)");
			conn = dbConn.getConnection();
			String SQL = "insert into test(num_id, title, content) "
					   + "values "
					   + "((select nvl(max(num_id), 0) + 1 from test), ?, ?) ";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BoardVO> select(BoardVO vo) {
		System.out.println(vo.getCh1() + ":" + vo.getCh2());
		List<BoardVO> li = new ArrayList<BoardVO> ();
		try {
			conn = dbConn.getConnection();
			if (vo.getCh1()==null || vo.getCh2().equals("")) {
				String SQL = "select * from test order by num_id ";
				pstmt = conn.prepareStatement(SQL);
			} else if(vo.getCh1().equals("title")) {
				String SQL = "select * from test where title like ? order by num_id ";
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, "%" + vo.getCh2() + "%");
				System.out.println(SQL);
			} else if(vo.getCh1().equals("content")) {
				String SQL = "select * from test where content like ? order by num_id ";
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, "%" + vo.getCh2() + "%");
				System.out.println(SQL);
			}
			rs = pstmt.executeQuery();
			BoardVO m = null;
			while(rs.next()) {
				m = new BoardVO();
				m.setNumid(rs.getInt("num_id"));
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));
				li.add(m);				
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public BoardVO selectNumid(int numId) {
		BoardVO m = null;
		try {
			conn = dbConn.getConnection();
			String SQL = "select * from test where num_id = ? ";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, numId);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				m = new BoardVO();
				m.setNumid(rs.getInt("num_id"));
				m.setTitle(rs.getString("title"));
				m.setContent(rs.getString("content"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

}
