package com.ud.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ud.base.entity.User;
import com.ud.base.entity.UserAccount;
import com.ud.base.entity.UserInfo;
import com.ud.base.service.UserAccountService;
import com.ud.base.service.UserInfoService;
import com.ud.base.service.UserService;
import com.ud.base.util.HandleStatus;
import com.ud.base.util.JSONResult;
import com.ud.base.util.UserContext;

@Controller
public class UserController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private UserAccountService userAccountService;

	/**
	 * 用户注册
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("register")
	@ResponseBody
	public JSONResult register(String username, String password) {
		JSONResult result = new JSONResult();
		int status = userService.register(username, password);
		if (status == HandleStatus.FAILURE) {
			result.setSuccess(false);
			result.setMsg("用户名已存在");
		}
		return result;
	}
	
	/**
	 *检查用户名是否重复
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping("isWithoutUsername")
	@ResponseBody
	public boolean isWithoutUsername(String username) {
		return userService.isWithoutUsername(username);
	}
	
	/**
	 * 用户登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("login")
	@ResponseBody
	public JSONResult login(String username,String password,HttpServletRequest request){
		JSONResult result = new JSONResult();
		String ip =request.getRemoteAddr();
		int status = userService.login(username,password,ip);
		if (status==HandleStatus.FAILURE) {
			result.setSuccess(false);
			result.setMsg("用户名或密码错误");
		}
		
		return result;
	}
	
	/**
	 * 跳转到个人中心
	 * 
	 * @return
	 */
	@RequestMapping("personIndex")
	public String jumpToPersonIndex(Model model){
		User user = UserContext.getCurrent();
		
		//查询出用户账户对象
		UserAccount userAccount = userAccountService.selectByUserId(user.getId());
		
		//查询出用户资料对象
		UserInfo userInfo = userInfoService.selectByUserId(user.getId());
		
		model.addAttribute("userAccount",userAccount);
		model.addAttribute("userInfo",userInfo);
		model.addAttribute("user", user);
		model.addAttribute("currentURL", ".personIndex");
		
		
		return "personIndex";
	}
	
	/**
	 * 注销
	 * 注销完成后回到首页
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(){
		userService.logout();
		
		return "redirect:index.html";
	}
	
	

	
	
}
