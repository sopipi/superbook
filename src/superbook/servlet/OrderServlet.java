package superbook.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import superbook.bean.Book;
import superbook.bean.Orders;
import superbook.bean.Product;
import superbook.dao.BookDao;
import superbook.dao.OrdersDao;
import superbook.dao.ProductDao;
import superbook.util.JSONUtil;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	/**测试完毕
	 * 展示主页面
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid = Integer.parseInt(String.valueOf(req.getAttribute("uid")));
		System.out.println("进入到showIndex方法");
		JSONArray array = new JSONArray();
		//解析上传参数
		Map<String, Object> map = new JSONUtil().getJSONParameter(req);
		
		//获得订单
		List<Orders> orderList = new OrdersDao().selectOrders();
		for(Orders o : orderList) {
			JSONObject result = new JSONObject();
			System.out.println("o" + o.toString());
			result.put("order", o);
			System.out.println(result.toString());
			//获得产品
			System.out.println(o.getPid());
			Product p = new ProductDao().selectByPid(o.getPid());
			result.put("product", p);
			System.out.println("p" + p.toString());
			//获得书籍
			Book  b = new BookDao().selectByIsbn(p.getIsbn());
			result.put("book", b);
			System.out.println("b" + b.toString());
			array.add(result);
		}
		write(resp, array.toString());
		return;
	}
  
}
