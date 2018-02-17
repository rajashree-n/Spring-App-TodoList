package edu.neu.csye6220.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.neu.csye6220.domain.User;

@Controller
public class RedirectController {

	@RequestMapping(value = "/login")
	protected String login(HttpServletRequest request, HttpServletResponse response, @Valid User user, BindingResult bindingResult, Model model) throws Exception {   	      
	     return "login";

	}

	@RequestMapping(value = "/loginParent")
	protected String loginP(HttpServletRequest request, HttpServletResponse response, @Valid User user, BindingResult bindingResult, Model model) throws Exception {   	      
	     return "loginParent";

	}

	@RequestMapping(value = "/loginChild")
	protected String loginC(HttpServletRequest request, HttpServletResponse response, @Valid User user, BindingResult bindingResult, Model model) throws Exception {   	      
	     return "loginChild";

	}

	
	@RequestMapping(value = "/register")
	protected String Register(HttpServletRequest request, HttpServletResponse response, @Valid User user, BindingResult bindingResult, Model model) throws Exception {   	      
	     return "register";
	}
	

}
