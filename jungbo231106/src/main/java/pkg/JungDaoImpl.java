package pkg;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JungDaoImpl implements JungDao{
	DBConnection dBConnection = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public JungDaoImpl() {
		dBConnection = DBConnection.getInstance();
	}

	@Override
	public void insert(JungVO vo) {		
		conn = dBConnection.getConnection();
		String SQL = "insert into examtbl (sno, sname, kor, eng, math, hist, today, nowDate) values (?, ?, ?, ?, ?, ?, ?, sysdate)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vo.getSno());
			pstmt.setString(2, vo.getSname());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getEng());
			pstmt.setInt(5,  vo.getMath());
			pstmt.setInt(6, vo.getHist());
			pstmt.setString(7, vo.getToday());			
			//System.out.println(vo.getToday());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public int maxSno() {
		int maxNo = 0;
		try {
			conn=dBConnection.getConnection();
			String SQL = "select NVL(MAX(SNO) + 1 , '10001') maxSno from examtbl ";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				maxNo = rs.getInt("maxSno");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return maxNo;
	}
	
	@Override
	public List<JungVO> select() {
		List<JungVO> li = new ArrayList<JungVO>();
		try {
			conn = dBConnection.getConnection();
			String SQL = "select sno, sname, kor, eng, math, hist, today, NVL(nowDate, SYSDATE) nowDate, cnt ";
			       SQL += " from examtbl order by sno asc";			
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			JungVO m = null;
			while(rs.next()) {
				m = new JungVO();
				m.setSno(rs.getString("sno"));
				m.setSname(rs.getString("sname"));
				m.setKor(rs.getInt("kor"));
				m.setEng(rs.getInt("eng"));
				m.setMath(rs.getInt("math"));
				m.setHist(rs.getInt("hist"));
				m.setToday(rs.getString("today"));
				m.setNowDate(rs.getDate("nowDate"));
				m.setCnt(rs.getInt("cnt"));
				li.add(m);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return li;
	}

	@Override
	public JungVO selectSno(int sno) {
		JungVO m = null;
		try {
			conn=dBConnection.getConnection();
			String SQL = "select sno, sname, kor, eng, math, hist, today, nowdate, cnt from examtbl where sno = ? ";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, sno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				m = new JungVO();
				m.setSname(rs.getString("sname"));
				m.setKor(rs.getInt("kor"));
				m.setEng(rs.getInt("eng"));
				m.setMath(rs.getInt("math"));
				m.setHist(rs.getInt("hist"));		
				m.setToday(rs.getString("today"));
				//m.setNowDate(rs.getString("nowDate"));
				m.setCnt(rs.getInt("cnt"));				
				m.setSno(rs.getString("sno"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return m;
	}

	@Override
	public void update(JungVO vo) {
		try {
			conn = dBConnection.getConnection();
			String SQL = "update examtbl set sname = ?, kor = ?, eng = ?, math = ?, hist = ?, today = ? where sno = ? ";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vo.getSname());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMath());
			pstmt.setInt(5, vo.getHist());
			pstmt.setString(6, vo.getToday());			
			pstmt.setString(7, vo.getSno());

			System.out.println("==========>UpdateJungDaoImpl :" + vo.getToday());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int sno) {
		try {
			conn = dBConnection.getConnection();
			String SQL = "delete from examtbl where sno = ? ";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, sno);
			System.out.println("==========jungDaoImpl");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void cnt(String sno) {
		try {
			conn = dBConnection.getConnection();
			String SQL = "update examtbl set cnt = cnt + 1 where sno = ? ";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, sno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
