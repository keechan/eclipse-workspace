package pkg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pkg.DBConnection.DBConnection;
import pkg.model.MemberVO;

public class MemberDaoImpl implements MemberDao{

	DBConnection DBCon = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet  rs = null;
	
	public MemberDaoImpl() {
		DBCon = DBConnection.getInstance();
	}
	
	@Override
	public void insert(MemberVO vo) {
		try {
			conn = DBCon.getConnection();
			String SQL = "insert into member200 (id, pwd, name, email) "
					   + "values (st1102.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberVO> select(MemberVO vo) {
		List<MemberVO> li = null;
		try {
			li = new ArrayList<MemberVO>();
			conn = DBCon.getConnection();
			
			String SQL = "select * from member200 order by id desc ";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			MemberVO m = null;
			while (rs.next()) {
				m = new MemberVO();
				m.setId(rs.getString("id"));
				m.setPwd(rs.getString("pwd"));
				m.setName(rs.getString("name"));
				m.setEmail(rs.getString("email"));
				li.add(m);
			};
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return li;
	}

	@Override
	public MemberVO edit(MemberVO vo) {
		MemberVO m = null;
		try {
			m = new MemberVO();
			conn = DBCon.getConnection();
			
			System.out.println(vo.getId());
			
			String SQL = "select * from member200 where id = ? ";
			pstmt = conn.prepareStatement(SQL);			
			pstmt.setString(1, vo.getId());		
			
//			System.out.println(rs.getString("id"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				m.setId(rs.getString("id"));				
				m.setPwd(rs.getString("pwd"));
				m.setName(rs.getString("name"));
				m.setEmail(rs.getString("email"));
			};
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return m;
	}

	@Override
	public void delete(MemberVO vo) {
		try {
			conn = DBCon.getConnection();
			String SQL = "delete member200 where id=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vo.getId());

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
