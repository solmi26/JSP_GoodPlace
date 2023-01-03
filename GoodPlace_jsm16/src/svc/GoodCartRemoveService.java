package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import dto.Cart;

public class GoodCartRemoveService {

	public void cartRemove(HttpServletRequest request, String[] tileArray) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");

		for (int i = 0; i < tileArray.length; i++) {

			for (int j = 0; j < cartList.size(); j++) {

				if (cartList.get(j).getC_title().equals(tileArray[i])) {
					cartList.get(j).setC_price(0);
					cartList.remove(cartList.get(j));

				}

			}

		}

	}
}