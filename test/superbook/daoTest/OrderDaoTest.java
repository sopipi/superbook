package superbook.daoTest;

import java.util.Date;

import org.junit.Test;

import superbook.bean.Orders;
import superbook.dao.OrdersDao;

public class OrderDaoTest {
	private OrdersDao dao = new OrdersDao();
	
	@Test
	public void add() {
		Orders o = new Orders();
		o.setUid(1);
		o.setOrderCode("312313");
		o.setOrderState(2);
		o.setPid(1);
		o.setBid(3);
		o.setReceiver(1);
		dao.add(o);
	}
	
	@Test
	public void changeUser() {
		dao.changeUser(3, 1, "测试", "123123");
	}
	
	
	@Test
	public void changePayDate() {
		dao.changePayDate(3,new Date());
	}
	@Test
	public void changedeliverDate() {
		dao.changedeliverDate(3,new Date());
	}
	@Test
	public void changeconfirmDate() {
		dao.changeconfirmDate(3,new Date());
	}
	
	@Test
	public void changeState() {
		dao.changeState(3,4);
	}
	
}
