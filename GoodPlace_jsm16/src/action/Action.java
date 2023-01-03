package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.ActionForward;

public interface Action {
	ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception;
}	
