package com.sist.mvc01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("hello","Spring에 오신 걸 환영합니다.");
		
		return "home";
	}//home() 메서드 end
	
	
	/*
	 * 스프링 MVC에서 Model(모델)이란 컨트롤러에 의해서 비지니스 로직이 수행되고 나면 대체로 사용자에게 
	 * 반환되어 브라우저에 표시될 정보들이 만들어진다. 이러한 정보를 스프링에서는 Model(모델)이라고 한다.
	 * 이 정보를 통해서 보통 JSP에 해당하는 View(뷰)로 보내어지게 된다. Model에서는 View로 보내질 정보가 저장된다.
	 */
	
	
	
	@RequestMapping("/memberInfo")//get방식. ->post방식으로 보내고 싶을땐 위에꺼 처럼 쓰고 .POST로 바꿔주면됨
	public String member(Model model) {
		
		model.addAttribute("name", "홍길동");//앞에는 키, 뒤에는 벨류값
		return "memberInfo";
		
	}//member() 메서드 end;
	
}
