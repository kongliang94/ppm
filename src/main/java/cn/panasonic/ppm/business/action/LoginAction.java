package cn.panasonic.ppm.business.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.panasonic.ppm.base.action.BaseAction;
import cn.panasonic.ppm.basedata.service.UserService;
import cn.panasonic.ppm.domain.basedata.User;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<User>{

	@Resource(name="userService")
	private UserService userService;
	
	public String login(){
		boolean flag=this.userService.checkLogin(this.getModel().getLogonname(),this.getModel().getLogonpwd());
		if(flag){
			User user=this.userService.getUserByName(this.getModel().getLogonname());
			saveSessionValue("user",user);
			return "loginSuccess";
		}else {
			return "loginFail";
		}
	}
}
