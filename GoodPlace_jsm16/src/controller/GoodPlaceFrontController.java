package controller;

import static db.JdbcUtil.getConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.CashAction;
import action.GoodCartAddAction;
import action.GoodCartListAction;
import action.GoodCartRemoveAction;
import action.GoodDeleteAction;
import action.GoodListAction;
import action.GoodRegistAction;
import action.GoodSearchAction;
import action.GoodUpdateAction;
import action.GoodUpdateFormAction;
import action.GoodViewAction;
import action.JoinAction;
import action.LoginAction;
import action.LogoutAction;
import action.MemberRemoveAction;
import dao.GoodDAO;
import dto.ActionForward;

@WebServlet("*.good")
public class GoodPlaceFrontController extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("get");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("post");
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1.요청파악
		String requestURI = request.getRequestURI();
		
		String contextPath = request.getContextPath();
		
		String command = requestURI.substring(contextPath.length());
		System.out.println(command);
		Action action = null;
		ActionForward forward = null;
		
		//2.각 요청별로 비즈니스 로직 호출
		if (command.equals("/views/goodList.good")){
			action = new GoodListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/views/goodView.good")){
			action = new GoodViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/views/goodCartAdd.good")){
			action = new GoodCartAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/views/goodCartList.good")){
			action = new GoodCartListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/views/goodSearch.good")){
			action = new GoodSearchAction();
			System.out.println(request.getParameter("search"));
			request.setAttribute("search", request.getParameter("search"));
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/views/goodCartRemove.good")){
			action = new GoodCartRemoveAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/views/cash.good")){
			action = new CashAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		else if(command.equals("/goodCartQtyUp.good")){
//			action = new GoodCartQtyUpAction();
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		else if(command.equals("/goodCartQtyDown.good")){
//			action = new GoodCartQtyDownAction();
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		else if(command.equals("/views/goodRegist.good")){
			action = new GoodRegistAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/views/goodUpdate.good")){
			action = new GoodUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/views/goodDelete.good")){
			action = new GoodDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/views/goodUpdateForm.good")){
			action = new GoodUpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/views/login.good")){
			action = new LoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/views/logout.good")){
			action = new LogoutAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/views/join.good")){
			action = new JoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/views/idCheck.good")){
			/* action = new IdCheckAction(); */
			try {
				String m_id = request.getParameter("userID");
				System.out.println(":" + m_id);
				GoodDAO goodDAO = GoodDAO.getInstance();
				Connection con = getConnection();
				goodDAO.setConnection(con);
				int result = goodDAO.idCheck(m_id);
				System.out.println(result);
				PrintWriter out = response.getWriter();
				if(result==0) {
					out.print(0);
				}else {
					out.print(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/views/nickCheck.good")){
			/* action = new IdCheckAction(); */
			try {
				String m_nickname = request.getParameter("userNICK");
				System.out.println("자바:"+m_nickname);
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/views/phoneCheck.good")){
			/* action = new IdCheckAction(); */
			try {
				String m_phone = request.getParameter("userPH");
				System.out.println(":" + m_phone);
				GoodDAO goodDAO = GoodDAO.getInstance();
				Connection con = getConnection();
				goodDAO.setConnection(con);
				int result = goodDAO.phoneCheck(m_phone);
				System.out.println(result);
				PrintWriter out = response.getWriter();
				if(result==0) {
					out.print(0);
				}else {
					out.print(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/views/emailCheck.good")){
			/* action = new IdCheckAction(); */
			try {
				String m_email = request.getParameter("userEMAIL");
				
				GoodDAO goodDAO = GoodDAO.getInstance();
				Connection con = getConnection();
				goodDAO.setConnection(con);
				int result = goodDAO.emailCheck(m_email);
				System.out.println(result);
				PrintWriter out = response.getWriter();
				if(result==0) {
					out.print(0);
				}else {
					out.print(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/views/memberRemove.good")){
			action = new MemberRemoveAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//3. 포워딩
		if(forward !=null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
				
			}
		}
		
	}
	
}
