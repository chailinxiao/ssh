package studio.lingye.book.action;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import studio.lingye.book.entity.Order;
import studio.lingye.book.service.OrderService;

@Controller
@Scope("prototype")
@ParentPackage(value = "struts-default")
@Namespace("/order")
public class OrderAction {

	@Autowired
	private OrderService orderService;
	
	HttpServletRequest request = ServletActionContext.getRequest();

	int oid;
	
	int page = 1;
	
	@Action(value = "/orderlist", results = { @Result(name = "orderlist", location = "/pages/back/order/order_list.jsp") })
	public String orderlist() {
		Order user = new Order();
		List<Order> list = orderService.findByExample(user);
		request.getSession().setAttribute("allItems", list);
		return "orderlist";
	}

	@Action(value = "/orderadd", results = { @Result(name = "orderadd", location = "/pages/back/order/order_insert.jsp") })
	public String add() {
		if(oid != 0) {
			Order user = orderService.findById(oid);
			request.setAttribute("user", user);
		}
		return "orderadd";
	}

	@Action(value = "/delOrder", results = { @Result(name = "orderlist", location = "/pages/back/order/order_list.jsp")})
	public String delOrder() {
		if(oid != 0) {
			Order user = new Order();
			user.setId(oid);
			orderService.deleteOrder(user);
		}
		
		Order uu = new Order();
		List<Order> uList = orderService.findByExample(uu);
		request.getSession().setAttribute("allItems", uList);
		return "orderlist";
	}
	
	@Action(value = "/createOrder", results = { 
			@Result(name = "orderist", location = "/pages/back/order/order_list.jsp"),
			@Result(name = "createOrder", location = "/pages/back/order/order_insert.jsp") 
		})
	public String createOrder() {
		String mobile = request.getParameter("price");
		float price = 0f;
		try{
			price = Float.parseFloat(mobile);
		} catch (Exception e) {
			
		}
		if (price > 0) {
			int iId = 0;
			try{
				iId = Integer.parseInt(request.getParameter("id"));
			}catch(Exception e){}
			Order user = new Order();
			user.setPrice(price);
			user.setNo(UUID.randomUUID().toString());
			user.setTime(System.currentTimeMillis());
			if (iId > 0) {
				user.setId(iId);
				orderService.updateOrder(user);
			} else {
				orderService.saveOrder(user);
			}
			Order uu = new Order();
			List<Order> uList = orderService.findByExample(uu);
			request.getSession().setAttribute("allItems", uList);
			return "orderist";
		} else {
			return  "createOrder";
		}
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}
	

}
