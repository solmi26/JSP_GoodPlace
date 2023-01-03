package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.GoodDAO;
import dto.Product;
public class GoodUpdateService {

	public boolean updateGood(Product good) {
		GoodDAO goodDAO = GoodDAO.getInstance();
		Connection con = getConnection();
		goodDAO.setConnection(con);		
		boolean isRegistSuccess = false;		
		int updateCount = goodDAO.updateGood(good);
		
		if(updateCount>0){
			commit(con);
			isRegistSuccess=true;
		}else{
			rollback(con);
		}
		
		close(con);
		return isRegistSuccess;
	}

}
