package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ActionForward;
import dto.Product;
import svc.GoodViewService;

public class GoodUpdateFormAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		GoodViewService goodViewService = new GoodViewService();
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		System.out.println(p_id);
		Product good = goodViewService.getGoodView(p_id);
		request.setAttribute("good", good);
		ActionForward forward = new ActionForward("update.jsp", false);
		return forward;
	}
}
