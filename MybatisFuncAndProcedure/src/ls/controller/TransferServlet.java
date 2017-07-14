package ls.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class TransferServlet extends MultiActionController {

	public TransferServlet(){
		System.out.println("TransferServlet 构造方法");
	}
	
	public ModelAndView indexTransfer(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		System.out.println("进入 index 转发");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("forward:index.action");
		//modelAndView.setViewName("WEB-INF/jsp/login.jsp");
		return modelAndView;
	}
	
}
