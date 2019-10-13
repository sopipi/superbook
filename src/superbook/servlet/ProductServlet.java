package superbook.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
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
import superbook.bean.ProductImage;
import superbook.dao.BookDao;
import superbook.dao.OrdersDao;
import superbook.dao.ProductDao;
import superbook.dao.ProductImageDao;
import superbook.util.BookUtil;
import superbook.util.ImageUtil;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet(
		urlPatterns = "/ProductServlet"
		)
public class ProductServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * 测试完毕
	 * 卖书(将信息存入数据库中) 
	 * 所需参数:isbn,cid,promotePrice,subTitle,degree,uid
	 * **
     * 所需头文件 Content-Type : application/x-www-form-urlencoded
     * 
     * 返回信息：flag：true
     * body form-data
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void sellBook(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
//	    1、解析传入参数
//	    2、调用图片存储，并获取地址
//	    3、根据ISBN码创建书籍信息
//	    4、创建产品信息，包括图片存储位置
//	    5、创建产品的箱子地址
//		JSONObject json = getJSONParameter(request);
		
		int uid = Integer.parseInt(String.valueOf(request.getAttribute("uid")));
		//解析传入参数
		Map<String, String> map = new HashMap<>();
		
		InputStream is = parseUpload(request, map);
		

        /*********************添加到数据库**************************/
        //添加product
        Product product = new Product();
        product.setCreateDate(new Date());
        product.setIsbn(map.get("isbn"));
        product.setCid(Integer.parseInt(map.get("cid")));
        product.setPromotePrice(Double.valueOf(map.get("promotePrice")));
        product.setSubTitle(map.get("subTitle"));
        product.setDegree(Integer.parseInt(map.get("degree")));
		(new ProductDao()).add(product);
		
		//添加ProductImage(用pid进行命名文件)
		ProductImage img = new ProductImage();
		img.setPid(new ProductDao().getPid());
		System.out.println(new ProductDao().getPid());
		
		//添加图片
		String imgposition = new ImageUtil().saveImage(is, request, String.valueOf(img.getPid()));
		System.out.println(imgposition);
		img.setImgposition(imgposition);
		(new ProductImageDao()).add(img);
		
		//添加Orders
		Orders orders = new Orders();
		orders.setUid(uid);
		orders.setPid((new ProductDao()).getPid());
		orders.setBid(1);
		orders.setReceiver(1);
		orders.setOrderState(1);
		System.out.println(orders.toString());
		(new OrdersDao()).add(orders);

		System.out.println(product.toString());
		System.out.println(orders.toString());
		JSONObject result = new JSONObject();
		result.put("flag", true);
	    write(response,result.toString());
	    return;
	}
	
	/**
	 * 测试完毕
	 * 检查书籍，进行支付
	 * 参数：uid
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		int uid = (int) req.getAttribute("uid");
		//解析传入参数
		Map<String, Object> map = (Map)getJSONParameter(req);
		
		int oid = (int) map.get("oid");
		(new OrdersDao()).changeState(oid, 2);
		JSONObject result = new JSONObject();
		result.put("flag", true);
		write(resp, result.toString());
		return;
	}
	
	
	
	
	
	public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException  {
		
	}
	
	/**
	 * 首页展示(根据类别cid展示书籍)
	 * 所需参数:cid
	 * @param request
	 * @param response
	 */
	public void showOrderListByCategory(HttpServletRequest request, HttpServletResponse response) {
		//解析传入参数
		Map<String, Object> map = (Map)getJSONParameter(request);
		
		//根据cid获取书籍
		int cid = (int)map.get("cid");
		System.out.println("ProductServlet.showOrderListByCategory: " + cid);
		List<Product> list = new ProductDao().selectByCid(cid);
		JSONArray jsonArray = new JSONArray();
		for(Product product : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("product", product);
			jsonObject.put("book", (new BookDao().selectByIsbn(product.getIsbn())));
			jsonArray.add(jsonObject);
		}
		write(response,jsonArray.toString());
	}
	
	
	/**
	 * 搜索框（根据书名，返回书籍订单列表）
	 * 所需参数：bookname，
	 * 返回参数：Book对象、Product对象
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showOrderListByName(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException  {
		//解析上传参数
		Map<String, Object> map = (Map)getJSONParameter(request);
		//1 根据书名获取ISBN
		String title = (String) map.get("title");
		System.out.println(title);
		Book book = new BookDao().selectByBookTitle(title);
		//2 根据ISBN获取产品号（Pid）
		List<Product> product = new ProductDao().selectListByISBN(book.getIsbn());
		//3 返回信息
		JSONObject json = new JSONObject();
		json.put("book", book);
		json.put("product", product);
		write(response,json.toString());
		
	}
}
