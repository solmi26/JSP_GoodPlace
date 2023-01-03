package action;


import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GoodDAO;
import dto.ActionForward;
import dto.Member;
import dto.Product;
import svc.GoodDeleteService;

public class MemberRemoveAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String m_id = request.getParameter("m_id");
		System.out.println(m_id);
		
		GoodDAO goodDAO = GoodDAO.getInstance();
		Connection con = getConnection();
		goodDAO.setConnection(con);
		int result = goodDAO.deleteMember(m_id);
		
		if (result == 1) {
			request.setAttribute("message", "탈퇴가 완료되었습니다.");
			session.invalidate();
			commit(con);
		} else if (result == 0) {
			request.setAttribute("message", "다시 시도해주세요.");
			rollback(con);
		} 
		
		close(con);
		ActionForward forward = new ActionForward("goodList.good", false);
		return forward;
	}
}
