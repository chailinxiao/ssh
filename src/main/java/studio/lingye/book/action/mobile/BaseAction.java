package studio.lingye.book.action.mobile;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

public class BaseAction {

	public String ajax(Object out){
		PrintWriter writer = null;
		try {
			HttpServletResponse response = ServletActionContext.getResponse();		
			response.setContentType("application/json;charset=utf-8");
			writer = response.getWriter();
			response.setDateHeader("Expires", 0);
			JSONObject object = JSONObject.fromObject(out);
			writer.write(object.toString());
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(writer!=null){
				writer.close();
			}
		}
		return null;
	}
	
}
