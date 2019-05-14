package studio.lingye.book.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import studio.lingye.book.entity.User;
import studio.lingye.book.service.UserService;
import studio.lingye.book.util.Md5;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Namespace("/user")
public class UserAction {

	@Autowired
	private UserService userService;
	
	HttpServletRequest request = ServletActionContext.getRequest();

	int uid;
	
	int page = 1;
	
	@Action(value = "/userlist", results = { @Result(name = "userList", location = "/pages/back/member/item_list.jsp") })
	public String userlist() {
		User user = new User();
		List<User> list = userService.findByExample(user);
		request.getSession().setAttribute("allItems", list);
		
		return "userList";
	}

	@Action(value = "/add", results = { @Result(name = "add", location = "/pages/back/member/member_insert.jsp") })
	public String add() {
		if(uid != 0) {
			User user = userService.findById(uid);
			request.setAttribute("user", user);
		}
		return "add";
	}

	@Action(value = "/del", results = { @Result(name = "userList", location = "/pages/back/member/item_list.jsp")})
	public String del() {
		if(uid != 0) {
			User user = new User();
			user.setId(uid);
			userService.deleteUser(user);
		}
		
		User uu = new User();
		List<User> uList = userService.findByExample(uu);
		request.getSession().setAttribute("allItems", uList);
		return "userList";
	}
	
	@Action(value = "/create", results = { 
			@Result(name = "userList", location = "/pages/back/member/item_list.jsp"),
			@Result(name = "create", location = "/pages/back/member/member_insert.jsp") 
		})
	public String create() {
		String mobile = request.getParameter("mobile");
		if (StringUtils.isNotEmpty(mobile)) {
			int iId = 0;
			try{
				iId = Integer.parseInt(request.getParameter("id"));
			}catch(Exception e){}
			
			boolean isCanSave = false;
			if (iId > 0) {
				isCanSave = true;
			} else {
				User u = new User();
				u.setMobile(mobile);
				List<User> list = userService.findByExample(u);
				if (list.isEmpty()) {
					isCanSave = true;
				}
			}
			if(isCanSave){
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String role = request.getParameter("role");
				String age = request.getParameter("age");
				int iAge = 0;
				try{
					iAge = Integer.parseInt(age);
				}catch(Exception e) {
					
				}
				User user = new User();
				user.setPassword(Md5.getMd5(password));
				user.setRole(role);
				user.setAge(iAge);
				user.setUsername(username);
				user.setMobile(mobile);
				if (iId > 0) {
					user.setId(iId);
					userService.updateUser(user);
				} else {
					userService.saveUser(user);
				}
				
				
				User uu = new User();
				List<User> uList = userService.findByExample(uu);
				request.getSession().setAttribute("allItems", uList);
				return "userList";
			} else {
				request.setAttribute("msg", "手机号已存在");
				return  "create";
			}
		} else {
			return  "create";
		}
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	

}
