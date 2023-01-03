package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.GoodDAO;
import dto.Product;
public class GoodListService {

	public ArrayList<Product> getGoodList() {
		GoodDAO goodDAO = GoodDAO.getInstance();
		Connection con = getConnection();
		goodDAO.setConnection(con);		
		ArrayList<Product> goodList = goodDAO.selectGoodList();
		close(con);
		return goodList;
	}
	
}