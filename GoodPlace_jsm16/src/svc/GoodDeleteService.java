package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.GoodDAO;
import dto.Product;
public class GoodDeleteService {

	public boolean deleteGood(int p_id) {
		GoodDAO goodDAO = GoodDAO.getInstance();
		Connection con = getConnection();
		goodDAO.setConnection(con);	
		
		boolean good = goodDAO.deleteGood(p_id);
		System.out.println("서비스:"+p_id);
		
		if(good) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		System.out.println(good);
		return good;
	}

}
