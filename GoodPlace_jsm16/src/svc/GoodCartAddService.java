package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import dto.Cart;
import dto.Product;
import dao.GoodDAO;

public class GoodCartAddService {

	public Product getCartGood(int p_id) {
		Connection con = getConnection();
		GoodDAO goodDAO = GoodDAO.getInstance();
		goodDAO.setConnection(con);	
		Product good = goodDAO.selectGood(p_id);
		close(con);
		return good;
	}

	public void addCart(HttpServletRequest request, Product cartGood, int c_price) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		if(cartList == null){
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		
		boolean isNewCart = true;
		//지금 장바구니에 담는 항목이 새로 추가되는 항목인지를 저장할 변수
		
		for (int i = 0; i < cartList.size(); i++) {
			if(cartGood.getP_title().equals(cartList.get(i).getC_title())){
				isNewCart = false;
				cartList.get(i).setC_price(cartList.get(i).getC_price()+c_price);
				break;
			}
		}
		
		if(isNewCart){
			Cart cart = new Cart();
			cart.setC_id(cartGood.getP_id());
			cart.setC_image(cartGood.getP_img());
			cart.setC_title(cartGood.getP_title());
			cart.setC_inst(cartGood.getP_inst());
			cart.setC_price(c_price);

			cartList.add(cart);
		}
		
	}
	
}