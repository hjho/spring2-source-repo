package com.kosmo.ver2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common/*")
public class CommonController {	
	@RequestMapping("test")
	public String test() {
		return "redirect:test.jsp";
	}
}
