package action;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GoodDAO;
import dto.ActionForward;
import dto.Member;

public class LoginAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "./login.jsp";
		String m_id = request.getParameter("m_id");
		System.out.println(m_id);
		String m_pw = request.getParameter("m_pw");

		GoodDAO goodDAO = GoodDAO.getInstance();
		Connection con = getConnection();
		goodDAO.setConnection(con);
		int result = goodDAO.userCheck(m_id, m_pw);

		if (result == 1) {
			Member member = goodDAO.getMember(m_id);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", member);
			url = "goodList.good";
		} else if (result == 0) {
			request.setAttribute("message", "비밀번호를 확인해주세요.");
		} else if (result == -1) {
			request.setAttribute("message", "존재하지 않는 아이디입니다.");
		}
		
		close(con);
		ActionForward forward = new ActionForward(url, false);
		return forward;
	}
}
