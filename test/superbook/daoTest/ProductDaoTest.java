package superbook.daoTest;

import java.util.Date;

import org.junit.Test;

import superbook.dao.ProductDao;

public class ProductDaoTest {
	private ProductDao dao = new ProductDao();
	
	@Test
	public void changedegree() {
		dao.changedegree(1, 3);
	}
	@Test
	public void changepromotePrice() {
		dao.changepromotePrice(1, 3);
	}
	@Test
	public void changecreateDate() {
		dao.changecreateDate(1, new Date());
	}
	
	@Test
	public void selectByPid() {
		dao.selectByPid(1);
	}
}
