package action;

import static db.JdbcUtil.getConnection;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GoodDAO;
import dto.ActionForward;
import dto.Member;

public class NicknameCheckAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String m_nickname = request.getParameter("userNICK");
		
		GoodDAO goodDAO = GoodDAO.getInstance();
		Connection con = getConnection();
		goodDAO.setConnection(con);
		int result = goodDAO.nicknameCheck(m_nickname);
		System.out.println(result);
		PrintWriter out = response.getWriter();
		if(result==0) {
			out.print(0);
		}else {
			out.print(1);
		}
		
		
		ActionForward forward = new ActionForward("join.jsp", false);
		return forward;
	}
}
