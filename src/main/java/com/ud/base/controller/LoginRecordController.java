package com.ud.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.ud.base.entity.LoginRecord;
import com.ud.base.entity.User;
import com.ud.base.service.LoginRecordService;
import com.ud.base.util.UserContext;

@Controller
public class LoginRecordController extends BaseController {

	@Autowired
	private LoginRecordService loginRecordService;

	/**
	 * 登录日志查询
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("loginRecord")
	public String loginRecord(Model model, @RequestParam(name = "pageNum", defaultValue = "1") int pageNum //
			, @RequestParam(name = "paseSize", defaultValue = "10") int pageSize) {
		User user = UserContext.getCurrent();
		model.addAttribute("user",user );
		model.addAttribute("currentURL", ".loginRecord");
		Page<LoginRecord> pageList = loginRecordService.findByPage(pageNum, pageSize,user.getUsername());
//		pageList.get
		model.addAttribute("pageList", pageList);
		return "loginRecord";
	}
}
