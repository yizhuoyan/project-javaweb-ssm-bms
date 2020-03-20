package web.handler;

import dto.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.UserService;
import util.BMSException;
import util.ThisSystemUtil;

import java.util.Map;

@Controller
public class LoginHandler extends AbstractHandler{
	@Autowired
	private UserService us;
	
	@PostMapping(path="/login")
	public String login(@RequestParam(name="account",required=true) String account,String password,WebRequest req)throws Exception {
		// 2参数适配
		try {
			// 3执行业务层方法//4获取业务结果(如果有的话)
			UserContext uc = us.login(account, password);
			// 5组装模型
			req.setAttribute("currentUser",uc.getUser(), WebRequest.SCOPE_SESSION);
			/*
			HttpSession session=req.getSession();
			session.setAttribute("currentUser", uc.getUser());
			*/
			// 6页面跳转(视图处理)
			//return "redirect:/WEB-INF/page/index.jsp";
			return "redirect:index.do";
		} catch (BMSException e) {
			req.setAttribute("message", e.getMessage(),WebRequest.SCOPE_REQUEST);
		} 
		// 6页面跳转(视图处理)-异常
		return "forward:/login.jsp";
	}
	
	@RequestMapping("/index.do")
	public String index(){
		return "index";
	}
	
	//@RequestMapping(path="/modifyPassword.do",method=RequestMethod.POST)
	@PostMapping("/modifyPassword.do")
	public String modifyPassword(String userId,
			@RequestParam("oldPassword")
			String oldPassword,
			@RequestParam("newPassword")
			String newPassword,
			@RequestParam("newPasswordConfirm")
			String newPasswordConfirm,
			Map map,
			RedirectAttributes attributes
			)throws Exception{
		if(ThisSystemUtil.isBlank(userId)){
			//从session中获取
			userId=this.getCurrentUserId();
		}
		try{
			us.modifyPassword(userId, oldPassword, newPassword, newPasswordConfirm);
			//成功,重定向到登录页面，要求重新登录
			String message="修改成功，请重新登录!";
			//相当于放入session
			attributes.addFlashAttribute("message",message);
			//下面这种相当于是把值加到url后面
			//attributes.addAttribute("message",message);
			return "redirect:/login.do";
		}catch(BMSException e){
			//req.setAttribute("message", e.getMessage());
			map.put("message", e.getMessage());
		}
		//失败，到修改密码页面
		return "center/modify-password";
	}
	@GetMapping("/login.do")
	public String login(@ModelAttribute("message")  String message){
		return "forward:/login.jsp";
	}
	@GetMapping("/age.do")
	public String f(@RequestParam("age") int age){
		return "index";
	}

}


