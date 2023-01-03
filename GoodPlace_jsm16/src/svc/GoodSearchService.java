package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.GoodDAO;
import dto.Product;

public class GoodSearchService {
	public ArrayList<Product> getGoodList(String search) {
		GoodDAO goodDAO = GoodDAO.getInstance();
		Connection con = getConnection();
		goodDAO.setConnection(con);		
		ArrayList<Product> goodList = goodDAO.selectGoodListTitle(search);
		close(con);
		return goodList;
	}
}
