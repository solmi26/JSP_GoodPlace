package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.GoodCartListService;
import dto.ActionForward;
import dto.Cart;

//장바구니 목록보기
public class GoodCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		GoodCartListService goodCartListService = new GoodCartListService();
		ArrayList<Cart> cartList = goodCartListService.getCartList(request);
		//총금액 계산
		int totalMoney = 0;
		int money = 0 ;
		
		if(cartList!=null) {
		for (int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getC_price();
			totalMoney += money;
		}}

		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		ActionForward forward = new ActionForward("cart.jsp", false);
		return forward;
	}
	

}
