package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodDAO;
import dto.ActionForward;
import dto.Product;
import svc.GoodDeleteService;

public class GoodDeleteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		GoodDeleteService goodDeleteService = new GoodDeleteService();
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		System.out.println(p_id);
		
		goodDeleteService.deleteGood(p_id);

		
		ActionForward forward = new ActionForward("goodList.good", false);
		return forward;
	}
}
