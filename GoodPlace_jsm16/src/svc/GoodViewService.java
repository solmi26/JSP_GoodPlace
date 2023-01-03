package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dto.Product;
import dao.GoodDAO;
public class GoodViewService {

	public Product getGoodView(int p_id) {
		Connection con = getConnection();
		GoodDAO goodDAO = GoodDAO.getInstance();
		goodDAO.setConnection(con);	
		
		Product good = goodDAO.selectGood(p_id);
		close(con);
		return good;
	}

}
