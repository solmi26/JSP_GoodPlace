package action;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import svc.GoodRegistService;
import svc.GoodUpdateService;
import dto.ActionForward;
import dto.Product;

public class GoodUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		GoodUpdateService GoodUpdateService = new GoodUpdateService();
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		String realFolder = "C:\\JSP-기말\\GoodPlace_jsm16\\WebContent\\resources\\img";
		//파일 업로드 될 서버 상의 물리적인 경로
	
		String encType = "UTF-8";
		int maxSize = 5*1024*1024;
		//한 번에 업로드할 수 있는 파일의 크기
		
		
		ServletContext context = request.getServletContext();
		System.out.println(context);
		/* realFolder = context.getRealPath(saveFolder); */
		MultipartRequest multi = new MultipartRequest(request,
					realFolder, maxSize, encType,
					new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("p_img");
		if(image==null) {
			image = multi.getParameter("temp_img");
		}
		Product good =  new Product() ;
		good.setP_id(p_id);
		good.setP_category(multi.getParameter("p_category"));
		good.setP_title(multi.getParameter("p_title"));
		good.setP_price(Integer.parseInt(multi.getParameter("p_price")));
		good.setP_period(multi.getParameter("p_period"));
		good.setP_inst(multi.getParameter("p_inst"));
		good.setP_desc(multi.getParameter("p_desc"));
		good.setP_img(image);
		

		boolean isRegistSuccess = GoodUpdateService.updateGood(good);
		ActionForward forward = null;
		
		
		if(isRegistSuccess){
			PrintWriter out = response.getWriter();
			out.println("<script>alert('수정 성공')</script>");
			forward = new ActionForward("goodList.good", true);
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
