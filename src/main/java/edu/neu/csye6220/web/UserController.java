package edu.neu.csye6220.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.neu.csye6220.domain.Todo;
import edu.neu.csye6220.domain.User;
import edu.neu.csye6220.service.TodoService;
import edu.neu.csye6220.service.UserService;


@Controller
public class UserController {

	@Autowired
    private UserService userService;
	
	@RequestMapping(value = "/logging", method = RequestMethod.POST)
	protected String doLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response, User user, BindingResult bindingResult, Model model) throws Exception {   	      
		 if (bindingResult.hasErrors()) {
	            model.addAttribute("error", "register.error.global");
			return "login";
		}
		 final String newEmail = user.getEmail();

		 if (!(emailIsAlreadyUsed(newEmail))) {
			 model.addAttribute("error", "Invalid entry user doesnot exists");
	            return "login";
	        }
		 User user1 = userService.getUserByEmail(newEmail);
	        model.addAttribute("user", user1);
	        session.setAttribute("Parent", user1);
	     return "mylistInt";
	}

	@RequestMapping(value = "/profile")
	protected String profile(HttpSession session, HttpServletRequest request, HttpServletResponse response, User user, BindingResult bindingResult, Model model) throws Exception {   	      
		 if (bindingResult.hasErrors()) {
	            model.addAttribute("error", "register.error.global");
			return "profile";
		}
		 User us = (User) session.getAttribute("Parent");
		 User usr = (User) userService.getUserByEmail(us.getEmail());
	        model.addAttribute("user", usr);
	     return "profile";

	}
	
	@RequestMapping(value = "/profileC")
	protected String profileChild(HttpSession session, HttpServletRequest request, HttpServletResponse response, User user, BindingResult bindingResult, Model model) throws Exception {   	      
		 if (bindingResult.hasErrors()) {
	            model.addAttribute("error", "register.error.global");
			return "profileChild";
		}
		 User us = (User) session.getAttribute("Parent");
		 User usr = (User) userService.getUserByEmail(us.getEmail());
	        model.addAttribute("user", usr);
	     return "profileChild";

	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	protected String profileUpdate(HttpSession session, HttpServletRequest request, HttpServletResponse response,@Valid User user, BindingResult bindingResult, Model model) throws Exception {   	      
		 if (bindingResult.hasErrors()) {
	            model.addAttribute("error", "register.error.global");
			return "profile";
		}
		 User user1 = new User();
	        user1.setFname(user.getFname());
	        user1.setEmail(user.getEmail());
	        user1.setPassword(user.getPassword());
		 userService.update(user1);
		 session.setAttribute("Parent1", user1);
		 model.addAttribute("user", user1);
	     return "profile";

	}
	
	@RequestMapping(value = "/loggingParent", method = RequestMethod.POST)
	protected String doLoginP(HttpSession session, HttpServletRequest request, HttpServletResponse response, User user, BindingResult bindingResult, Model model) throws Exception {   	      
		 if (bindingResult.hasErrors()) {
			return "login";
		}
		 final String newEmail = user.getEmail();

		 if (!(emailIsAlreadyUsed(newEmail))) {
			 model.addAttribute("error", "Invalid entry user doesnot exists");
	            return "login";
	        }
		 User user1 = userService.getUserByEmail(newEmail);
	        model.addAttribute("user", user1);
	     return "mylist";

	}
	
	@RequestMapping(value = "/loggingChild", method = RequestMethod.POST)
	protected String doLoginC(HttpSession session, HttpServletRequest request, HttpServletResponse response, User user, BindingResult bindingResult, Model model) throws Exception {   	      
		 if (bindingResult.hasErrors()) {
			return "login";
		}
		 final String newEmail = user.getEmail();

		 if (!(emailIsAlreadyUsed(newEmail))) {
			 model.addAttribute("error", "Invalid entry user doesnot exists");
	            return "login";
	        }
		 User user1 = userService.getUserByEmail(newEmail);
	        model.addAttribute("user", user1);
	     return "mylistchild";

	}
	  private boolean emailIsAlreadyUsed(String email) throws Exception {
	        return userService.getUserByEmail(email) != null;
	    }
	
	@RequestMapping(value = "/registering", method = RequestMethod.GET)
	protected String doRegister(HttpServletRequest request, HttpServletResponse response,@Valid User user, BindingResult bindingResult, Model model) throws Exception {   	      
		
	        String newEmail = user.getEmail();
	        if (bindingResult.hasErrors()) {
	        	
				return "login";
			}
		 if (emailIsAlreadyUsed(newEmail)) {
			 model.addAttribute("error", "Invalid entry user exists");

	            return "register";
	        }
		 
		 User user1 = new User();
	        user1.setFname(user.getFname());
	        user1.setEmail(newEmail);
	        user1.setPassword(user.getPassword());
	        user1 = userService.create(user1);
	        model.addAttribute("user", user1);
			model.addAttribute("suc", "Successfully Created account. Login again with same credentials");

	     return "login";

	}

	

}
