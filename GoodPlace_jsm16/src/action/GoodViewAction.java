package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.GoodViewService;
import dto.ActionForward;
import dto.Product;

//상세보기
public class GoodViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		GoodViewService goodViewService = new GoodViewService();
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		Product good = goodViewService.getGoodView(p_id);
		request.setAttribute("good", good);
		ActionForward forward = new ActionForward("product.jsp", false);
		return forward;
	}
	
}