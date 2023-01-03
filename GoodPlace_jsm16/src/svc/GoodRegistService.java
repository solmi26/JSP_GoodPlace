package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.GoodDAO;
import dto.Product;
public class GoodRegistService {

	public boolean registGood(Product good) {
		GoodDAO goodDAO = GoodDAO.getInstance();
		Connection con = getConnection();
		goodDAO.setConnection(con);					
		boolean isRegistSuccess = false;		
		int insertCount = goodDAO.insertGood(good);
		System.out.println(insertCount);
		if(insertCount>0){
			commit(con);
			isRegistSuccess=true;
		}else{
			rollback(con);
		}
		
		close(con);
		return isRegistSuccess;
	}

}
