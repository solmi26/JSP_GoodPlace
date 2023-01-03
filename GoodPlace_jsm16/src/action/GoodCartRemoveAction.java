package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.GoodCartRemoveService;
import dto.ActionForward;

//장바구니 삭제
public class GoodCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] titleArray = request.getParameterValues("remove");
		//int[] idArray =  request.getParameterValues("remove");
		//for(String a:titleArray) {
		//	System.out.println(a);
		//}
		if(titleArray==null) {

			ActionForward forward = new ActionForward("goodCartList.good",true);
			return forward;
		}else {GoodCartRemoveService goodCartRemoveService = new GoodCartRemoveService();
		goodCartRemoveService.cartRemove(request,titleArray);
		ActionForward forward = new ActionForward("goodCartList.good",true);
		return forward;
		}
		
		
	}
	
}