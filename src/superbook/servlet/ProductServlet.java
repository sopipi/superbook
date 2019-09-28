package superbook.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet(
		urlPatterns = "/ProductServlet"
		)
public class ProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
//  添加产品，卖书
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
//	    1、解析传入参数
//	    2、调用图片存储，并获取地址
//	    3、根据ISBN码创建书籍信息
//	    4、创建产品信息，包括图片存储位置
//	    5、创建产品的箱子地址
		JSONObject json = getJSONParameter(request);
	    String a = json.getString("a");
	    System.out.println("a" + a);
		
	}
	
	public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException  {
		
	}
}
