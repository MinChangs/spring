package kr.or.ddit.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.main.model.MainVo;
import kr.or.ddit.user.model.UserVo;

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
@SessionAttributes("rangers")
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	//메서드에 적용된 @ModelAttribute
	  //@RequestMapping이 붙은 메서드가 실행될때(요청이 처리될때)
	  //@ModelAttribute가 적용된 메서드가 리턴하는 값을 Model객체에 자동적으로 넣어준다
	  // localhost/main  --> @RequestMapping("/main") : mainView --> Model에는 rangers 속성이 들어가 있다.
      // localhost/main  --> @mainMav : mainView --> Model에는 rangers 속성이 들어가 있다.
	
	
	@ModelAttribute("rangers")
	public List<String> rangers(){
		
		logger.debug("{}","rangers()");
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		rangers.add("james");
		rangers.add("moon");
		
		return rangers;
	}
	/**
	* Method : mainView
	* 작성자 : PC24
	* 변경이력 :
	* @param model
	* @return
	* Method 설명 : main페이지 요청(ViewName)
	*/
	@RequestMapping("/main")
	public String mainView(/* HttpServletRequest request, */ Model model,
							@ModelAttribute("userVo")UserVo userVo) {
		
		
		logger.debug("mainView");
		logger.debug("model.asMap().get(\"rangers\") : {}", model.asMap().get("rangers"));
//		UserVo userVo= new UserVo();
		logger.debug("userVo : {}", userVo);
		userVo.setName("브라운");
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
	
	
	
	/**
	* Method : mainViewMav
	* 작성자 : PC24
	* 변경이력 :
	* @return
	* Method 설명 : main 페이지 요청(ModelAndView 사용)
	*/
	@RequestMapping("/mainMav")
	public ModelAndView mainViewMav(@ModelAttribute("rangers") List<String> rangers) {
		logger.debug("mainviewMav : {}",rangers);
		//viewName을 기반으로 ModelAndView객체를 생성
		ModelAndView mav = new ModelAndView("main");
		//위 문장은 아래 두 문장과 같다 
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("main");
		
		//model.addAttribute("mainUserId","brown");
		mav.addObject("mainUserId","brown");
		
		return mav;
	}
	
	/**
	* Method : pathVariable
	* 작성자 : PC24
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : pathVariable로 부터 사용자 아이디 가져오기(ex:도서관 사업소)
	*/
	//localhost/main/pathvariable/brown
	//localhost/main/pathvariable/sally
	@RequestMapping("/main/pathvariable/{userId}")
	public String pathVariable(@PathVariable("userId") String userId) {
		logger.debug("userId : {}", userId);
		return "main";
	}
	
	/**
	* Method : header
	* 작성자 : PC24
	* 변경이력 :
	* @param accept
	* @return
	* Method 설명 : Accept header정보 가져오기
	*/
	@RequestMapping("/main/header")
	public String requestHeader(@RequestHeader(name = "Accept"/* , required = false */) String accept) {
		logger.debug("Accept : {} ", accept);
		return "main";
	}
	
	@RequestMapping("/main/view")
	public String view() {
		return "view";
	}
	
	@RequestMapping("/main/process")
	public String process(HttpServletRequest request, String[] userId, 
						// List<>타입의 경우 @RequestParam적용
						  @RequestParam("userId")List<String> userIdList,
						  String[] name,
						   MainVo mainVo) {
		
		String[] userIdArr=request.getParameterValues("userId");
		String userIdParameter = request.getParameter("userId");
		logger.debug("userIdParameter : {}", userIdParameter);		
		for(String u : userIdArr) 
			logger.debug("userId : {} ",u);
		
		logger.debug("request.getParameterValues(\"userId\")");
		for(String u : userId) 
			logger.debug("String[] userId : {} ",u);
		
		logger.debug("userIdList");
		for(String u : userIdList) 
			logger.debug("List<String> userIdList: {} ",u);
		
//		logger.debug("MainVo");
//		for(String u : mainVo) 
			logger.debug("mainVo.getUserId(): {} ",mainVo);
		
		
		
		return "main";
	}
	

	

}
