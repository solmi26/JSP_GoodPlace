package action;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GoodDAO;
import dto.ActionForward;
import dto.Member;

public class LogoutAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("member/login.jsp");
		
		ActionForward forward = new ActionForward("goodList.good", false);
		return forward;
	}
}
