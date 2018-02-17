package edu.neu.csye6220.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.neu.csye6220.domain.Message;
import edu.neu.csye6220.domain.Todo;
import edu.neu.csye6220.domain.User;
import edu.neu.csye6220.service.MessageService;
import edu.neu.csye6220.service.TodoService;
import edu.neu.csye6220.service.UserService;

@Controller
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageService msgService;

	@RequestMapping(value = "/mylistadd", method = RequestMethod.POST)
	protected String doAdd(User user,HttpServletRequest request, HttpServletResponse response, @Valid Todo todo, BindingResult bindingResult, Model model) throws Exception {   	      
		 if (bindingResult.hasErrors()) {
			return "redirect:/mylist";
		}
		 final String newEmail = user.getEmail();

		 User user1 = userService.getUserByEmail(newEmail);
		todo.setUser(user1);
		todoService.add(todo);
		//session.setAttribute("list", todoService.getTodo());
		model.addAttribute("list", todoService.getTodo());
	    model.addAttribute("user", user1);
	    model.addAttribute("res", "Added Todo!!");
		model.addAttribute("suc", "Success!");
		
	     return "redirect:/mylist";

	}
//sending message to parent about task completed
	@RequestMapping(value = "/msg", method = RequestMethod.POST)
	protected String doSendMessage(HttpServletRequest request, HttpServletResponse response, @Valid Todo msg, BindingResult bindingResult, Model model) throws Exception {   	      
		Message m1 = new Message();
		m1.setMsg(msg.getTodo());
		m1.setMsgid(msg.getId());
		msgService.add(m1);
		model.addAttribute("list", todoService.getTodo());
		model.addAttribute("alt", "Successfully sent notification!!");
	     return "mylistchild";
	}
	
	@RequestMapping(value = "/mylist")
	public String loadTodoList(User user,Model model, HttpSession session) throws Exception {
		 final String newEmail = user.getEmail();
		model.addAttribute(new Todo());
		model.addAttribute(new Message());
		session.setAttribute("list", todoService.getTodo());
		session.setAttribute("msgs", msgService.getMsg());
		model.addAttribute("list", todoService.getTodo());
		model.addAttribute("msgs", msgService.getMsg());
		User user1 = userService.getUserByEmail(newEmail);
	    model.addAttribute("user", user1);
	     return "mylist";

	}
	
	@RequestMapping(value = "/mylistchild", method = RequestMethod.GET)
	public String loadChildTodoList(Model model, HttpSession session) throws Exception {
		
		model.addAttribute(new Todo());
		session.setAttribute("list", todoService.getTodo());
		model.addAttribute("list", todoService.getTodo());
	     return "mylistchild";

	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String doDeleteTodoList(Model model, HttpSession session, String todo, User user) throws Exception {

			try {
				msgService.delete(todo);
				todoService.delete(todo);
				model.addAttribute("list", todoService.getTodo());
				model.addAttribute("msgs", msgService.getMsg());
				model.addAttribute("res", "Deleted Todo!!");
				model.addAttribute("suc", "Success!");
				 return "mylist";
			} catch (Exception e) {
				model.addAttribute("list", todoService.getTodo());
				model.addAttribute("msgs", msgService.getMsg());
				model.addAttribute("alt", "Error in deleting No notification message received for it!!");
				model.addAttribute("warn", "Warning!!");	
			}
			return "mylist";
	}
	
	@RequestMapping(value = "/deleteMsg", method = RequestMethod.POST)
	public String doDeleteMsg(Model model, HttpSession session, String msg) throws Exception {
		System.out.println("b4--" + msg);
		msgService.delete(msg);
		System.out.println("after--" + msg);
		model.addAttribute("msgs", msgService.getMsg());
	     return "redirect:/mylist";

	}
	
	@RequestMapping(value="/logout")
	public String showLogout(Model model, HttpSession session){		
		model.addAttribute("msg", "Successfully logout!");
		return "home";
		
	}
}
