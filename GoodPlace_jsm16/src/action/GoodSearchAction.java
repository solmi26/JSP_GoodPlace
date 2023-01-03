package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ActionForward;
import dto.Product;
import svc.GoodListService;
import svc.GoodSearchService;

public class GoodSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String search = request.getParameter("search");

		GoodSearchService goodSearchService = new GoodSearchService();

		ArrayList<Product> goodList = goodSearchService.getGoodList(search);
		request.setAttribute("goodList", goodList);
		ActionForward forward = new ActionForward("index.jsp", false);

		return forward;
	}}
