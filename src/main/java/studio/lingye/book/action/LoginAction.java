package studio.lingye.book.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import studio.lingye.book.entity.User;
import studio.lingye.book.service.UserService;
import studio.lingye.book.util.Md5;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Namespace("/")
public class LoginAction extends ActionSupport{
	
	private static final long serialVersionUID = -7032714226365030210L;
	
	HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();
	
	String aid;
	
	String password;
	
	@Autowired
	private UserService userService;
	
	@Action(value="/login2", results={
			@Result(name="login", location = "/login.jsp"),
			@Result(name="index", location = "/pages/index.jsp")
	})
	public String login2() {
		if(StringUtils.isNotEmpty(aid) && StringUtils.isNotEmpty(password)){//表示数据存在
			User user = new User();
			user.setMobile(aid);
			List<User> list = userService.findByExample(user);
			if (!list.isEmpty()) {
				User u = list.get(0);
        		if (Md5.getMd5(password).equals(u.getPassword())) {
        			request.getSession().setAttribute("aid", aid);//保存aid
        			request.getSession().setAttribute("name", u.getUsername());
        			request.getSession().setAttribute("role", u.getRole());
        			return "index";
        		} 
			}
			request.setAttribute("msg", "用户名或密码错误");
		} else {
			request.setAttribute("msg", "请先完善表单");
		}
		return "login";
	}
	
	@Action(value="/logout2", results={
			@Result(name="login", location = "/login.jsp")
	})
	public String logout2() {
		request.getSession().removeAttribute("aid");
		request.getSession().removeAttribute("role");
		return "login";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getAid() {
		return aid;
	}


	public void setAid(String aid) {
		this.aid = aid;
	}
	
}
