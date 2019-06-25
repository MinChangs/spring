package kr.or.ddit.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 servlet 
 	- extends HttpSerblet
 	- servlet-mapping(web.xml, @WebServlet)
 	- service -> doXXX
 spring
 	- pojo(Plan Old Java Object), @Controller
 	- @RequestMapping(class, method)
 	- @RequestMapping에 설정한 url method 호출
 */
@Controller
public class MainController {
	
	@RequestMapping("/main")
	public String mainView(/* HttpServletRequest request, */ Model model) {
		//prefix : /WEB-INF/views/
		//surffix : .jsp
		
		// prefix + viewName +surffix
		// /WEB-INF/views/main.jsp
		
		//아래문장은 다음과 동일하다
		//HttpServletRequest를 거의 사용하지않고 스프링에서 Model객체를 사용한다.
//		request.setAttribute("mainUserId","brown");
		model.addAttribute("mainUserId","brown");
		
		//viewName
		return "main";
	}
}
