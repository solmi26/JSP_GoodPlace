package action;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import svc.GoodRegistService;
import dto.ActionForward;
import dto.Product;

public class GoodRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		GoodRegistService GoodRegistService = new GoodRegistService();
		String realFolder = "C:\\JSP-기말\\GoodPlace_jsm16\\WebContent\\resources\\img";
		//파일 업로드 될 서버 상의 물리적인 경로
		
		String saveFolder = "/img";
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
		
		Product good =  new Product() ;
		good.setP_category(multi.getParameter("p_category"));
		good.setP_title(multi.getParameter("p_title"));
		good.setP_price(Integer.parseInt(multi.getParameter("p_price")));
		good.setP_period(multi.getParameter("p_period"));
		good.setP_inst(multi.getParameter("p_inst"));
		good.setP_desc(multi.getParameter("p_desc"));
		good.setP_img(image);
		

		boolean isRegistSuccess = GoodRegistService.registGood(good);
		System.out.println(isRegistSuccess);
		ActionForward forward = null;
		
		if(isRegistSuccess){
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록 성공');");
			out.println("</script>");
			forward = new ActionForward("goodList.good", true);
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
