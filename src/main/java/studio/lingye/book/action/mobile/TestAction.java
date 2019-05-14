package studio.lingye.book.action.mobile;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import studio.lingye.book.entity.User;

@Controller
@Scope("prototype")
@ParentPackage("base")
@Namespace("/api")
public class TestAction {

	User user ;
	
	@Action(value = "/test", results = { @Result(name = "success", type = "json", params = {"root", "user"}) })
	public String test() {
		
		user = new User();
		user.setAge(22);
		user.setUsername("sadas");
		return "success";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
