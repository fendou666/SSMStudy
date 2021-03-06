package ls.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ls.model.Student;
import ls.service.IStudentService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class IndexController extends AbstractController {
	private IStudentService stuService;
	
	public IStudentService getStuService() {
		return stuService;
	}

	public void setStuService(IStudentService stuService) {
		System.out.println("set stuService");
		this.stuService = stuService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		Student stu = stuService.selectByPrimaryKey(3L);
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("进入 index 请求");
		modelAndView.addObject("userName", stu.getName());
		modelAndView.setViewName("/WEB-INF/jsp/login.jsp");
		return modelAndView;
	}

}
