package action;

import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.GoodListService;
import dto.ActionForward;
import dto.Product;

public class GoodListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		ArrayList<String> todayImageList = new ArrayList<String>();
//		Cookie[] cookieArray = request.getCookies();
//		
//		if(cookieArray != null){
//			for (int i = 0; i < cookieArray.length; i++) {
//				if(cookieArray[i].getName().startsWith("today")){
//					todayImageList.add(cookieArray[i].getValue());
//				}
//			}
//		}
		
		GoodListService goodListService = new GoodListService();
		ArrayList<Product> goodList = goodListService.getGoodList();
		request.setAttribute("goodList", goodList);
//		request.setAttribute("todayImageList", todayImageList);
		ActionForward forward = new ActionForward("index.jsp", false);
		
		return forward;
	}
	
}
