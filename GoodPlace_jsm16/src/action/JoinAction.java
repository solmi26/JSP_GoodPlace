package action;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GoodDAO;
import dto.ActionForward;
import dto.Member;

public class JoinAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = "./join.jsp";
		String m_id = request.getParameter("m_id");
		System.out.println(m_id);
		String m_pw = request.getParameter("m_pw");
		String m_phone = request.getParameter("m_phone");
		String m_email = request.getParameter("m_email");
		String m_nickname = request.getParameter("m_nickname");
		
		Member member = new Member();
		member.setM_id(m_id);
		member.setM_pw(m_pw);
		member.setM_phone(m_phone);
		member.setM_email(m_email);
		member.setM_nickname(m_nickname);
		member.setM_class(1);
		
		GoodDAO goodDAO = GoodDAO.getInstance();
		Connection con = getConnection();
		goodDAO.setConnection(con);
		int result = goodDAO.insertMember(member);

		HttpSession session = request.getSession();
		if (result == 1) {
			session.setAttribute("m_id",member.getM_id());
			request.setAttribute("message", "회원가입이 완료되었습니다.");
			commit(con);
			url = "goodList.good";
		} else {
			request.setAttribute("message", "회원가입을 정보를 다시 입력해주세요.");
			rollback(con);
		} 
		close(con);
		
		ActionForward forward = new ActionForward(url, false);
		return forward;
	}
}
