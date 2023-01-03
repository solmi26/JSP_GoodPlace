package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.GoodCartAddService;
import dto.ActionForward;
import dto.Product;

//장바구니 담기
public class GoodCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		GoodCartAddService goodCartAddService = new GoodCartAddService();
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		int c_price;
		if(request.getParameter("c_price")==null||request.getParameter("c_price")=="") {
			c_price = 0;	
		}else {c_price = Integer.parseInt(request.getParameter("c_price"));}
				
		Product cartGood = goodCartAddService.getCartGood(p_id);
		goodCartAddService.addCart(request,cartGood,c_price);
		ActionForward forward = new ActionForward("goodCartList.good", true);
		return forward;
	}

}
