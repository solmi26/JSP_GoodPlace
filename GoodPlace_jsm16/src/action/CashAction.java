package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.GoodCartRemoveService;
import dto.ActionForward;
import dto.Cart;

//장바구니 삭제
public class CashAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
		cartList.clear();
		ActionForward forward = new ActionForward("goodCartList.good",true);
		return forward;
		}
		
		
	}
	
