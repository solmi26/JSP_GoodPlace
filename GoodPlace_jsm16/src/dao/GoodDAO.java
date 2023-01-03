package dao;

import static db.JdbcUtil.*;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import dto.Product;
import dto.Member;

public class GoodDAO {

	Connection con;
	private static GoodDAO boardDAO;

	private GoodDAO() {

	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public static GoodDAO getInstance() {

		if (boardDAO == null) {
			boardDAO = new GoodDAO();
		}

		return boardDAO;
	}

	public ArrayList<Product> selectGoodList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Product> goodList = null;

		try {
			pstmt = con.prepareStatement("SELECT * FROM product");
			rs = pstmt.executeQuery();
			System.out.println(pstmt);

			if (rs.next()) {
				goodList = new ArrayList<Product>();

				do {
					goodList.add(new Product(rs.getInt("p_id"), rs.getString("p_category"), rs.getString("p_title"),
							rs.getInt("p_price"), rs.getString("p_period"), rs.getString("p_inst"),
							rs.getString("p_desc"), rs.getString("p_img")));
				} while (rs.next());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return goodList;
	}

	public Product selectGood(int p_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product good = null;

		try {
			pstmt = con.prepareStatement("SELECT * FROM product WHERE p_id=?");
			pstmt.setInt(1, p_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				good = new Product(rs.getInt("p_id"), rs.getString("p_category"), rs.getString("p_title"),
						rs.getInt("p_price"), rs.getString("p_period"), rs.getString("p_inst"), rs.getString("p_desc"),
						rs.getString("p_img"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return good;
	}

	public ArrayList<Product> selectGoodListTitle(String p_title) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Product> goodList = null;

		try {
			pstmt = con.prepareStatement("SELECT * FROM product WHERE p_title like ?");
			pstmt.setString(1, "%" + p_title + "%");
			rs = pstmt.executeQuery();
			System.out.println(pstmt);

			if (rs.next()) {
				goodList = new ArrayList<Product>();

				do {
					goodList.add(new Product(rs.getInt("p_id"), rs.getString("p_category"), rs.getString("p_title"),
							rs.getInt("p_price"), rs.getString("p_period"), rs.getString("p_inst"),
							rs.getString("p_desc"), rs.getString("p_img")));
				} while (rs.next());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return goodList;
	}

	public Product selectGoodTitle(String p_title) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product good = null;

		try {
			pstmt = con.prepareStatement("SELECT * FROM product WHERE p_title like ?");
			pstmt.setString(1, "%" + p_title + "%");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				good = new Product(rs.getInt("p_id"), rs.getString("p_category"), rs.getString("p_title"),
						rs.getInt("p_price"), rs.getString("p_period"), rs.getString("p_inst"), rs.getString("p_desc"),
						rs.getString("p_img"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return good;
	}

	public int insertGood(Product good) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";

		try {
			sql = "INSERT INTO product (p_category,p_title,p_price,p_period,p_inst,p_desc,p_img) VALUES(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, good.getP_category());
			pstmt.setString(2, good.getP_title());
			pstmt.setInt(3, good.getP_price());
			pstmt.setString(4, good.getP_period());
			pstmt.setString(5, good.getP_inst());
			pstmt.setString(6, good.getP_desc());
			pstmt.setString(7, good.getP_img());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(insertCount);
		return insertCount;
	}

	public int updateGood(Product good) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "";
		try {
			sql = "UPDATE product set p_category = ?, p_title = ?, p_price = ?, p_period = ?, p_inst = ?, p_desc = ?, p_img = ? WHERE p_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, good.getP_category());
			pstmt.setString(2, good.getP_title());
			pstmt.setInt(3, good.getP_price());
			pstmt.setString(4, good.getP_period());
			pstmt.setString(5, good.getP_inst());
			pstmt.setString(6, good.getP_desc());
			pstmt.setString(7, good.getP_img());
			pstmt.setInt(8, good.getP_id());
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(updateCount);
		return updateCount;
	}

	public boolean deleteGood(int p_id) {
		PreparedStatement pstmt = null;
		boolean success = false;
		String sql = "";
		/* System.out.println("솔미"); */
		try {
			sql = "DELETE FROM product WHERE p_id = ?";
			pstmt = con.prepareStatement(sql);
			System.out.println(pstmt);
			pstmt.setInt(1, p_id);
			int count = pstmt.executeUpdate();
			System.out.println("삭제?" + count);
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("카운트:");
		return success;
	}

	public int userCheck(String m_id, String m_pw) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		String sql = "SELECT m_pw from member where m_id = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("m_pw") != null && rs.getString("m_pw").equals(m_pw)) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
				result = -1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return result;
	}

	public Member getMember(String m_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		String sql = "SELECT * FROM member where m_id = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new Member();
				member.setM_id(rs.getString("m_id"));
				member.setM_pw(rs.getString("m_pw"));
				member.setM_phone(rs.getString("m_phone"));
				member.setM_email(rs.getString("m_email"));
				member.setM_nickname(rs.getString("m_nickname"));
				member.setM_class(rs.getInt("m_class"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return member;
	}

	public int idCheck(String m_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 1;
		String sql = "SELECT * FROM member where m_id = ?";
		System.out.println(m_id);

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
					result = 0;

				} else {
					result = 1;
				}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
			if(con!=null) close(con);			
			close(pstmt);
			close(rs);
		}

		return result;
	}
	public int phoneCheck(String m_phone) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 1;
		String sql = "SELECT * FROM member where m_phone = ?";
		System.out.println(m_phone);

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_phone);
			rs = pstmt.executeQuery();

			if (rs.next()) {
					result = 0;

				} else {
					result = 1;
				}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
			if(con!=null) close(con);			
			close(pstmt);
			close(rs);
		}

		return result;
	}
	public int emailCheck(String m_email) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 1;
		String sql = "SELECT * FROM member where m_email = ?";
		System.out.println(m_email);

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
					result = 0;

				} else {
					result = 1;
				}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
			if(con!=null) close(con);			
			close(pstmt);
			close(rs);
		}

		return result;
	}
	public int nicknameCheck(String m_nickname) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 1;
		String sql = "SELECT * FROM member where m_nickname = ?";
		System.out.println(m_nickname);

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_nickname);
			rs = pstmt.executeQuery();

			if (rs.next()) {
					result = 0;

				} else {
					result = 1;
				}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) close(rs);
			if(pstmt!=null) close(pstmt);
			if(con!=null) close(con);			
			close(pstmt);
			close(rs);
		}

		return result;
	}
	
	public int insertMember(Member member) {
		PreparedStatement pstmt = null;
		int result = -1;
		/* int m_class = 1; */
		String sql = "INSERT INTO member values(?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getM_id());
			pstmt.setString(2, member.getM_pw());
			pstmt.setString(3, member.getM_phone());
			pstmt.setString(4, member.getM_email());
			pstmt.setString(5, member.getM_nickname());
			pstmt.setInt(6, member.getM_class());
			result = pstmt.executeUpdate();
			System.out.println("db:"+result);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) close(pstmt);		
			close(pstmt);
		}

		return result;
	}
	
	public int deleteMember(String m_id) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "";
		try {
			sql = "DELETE FROM member WHERE m_id = ?";
			pstmt = con.prepareStatement(sql);
			System.out.println(pstmt);
			pstmt.setString(1, m_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) close(pstmt);		
			close(pstmt);
		}
		return result;
	}

}
