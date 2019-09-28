package superbook.daoTest;

import org.junit.Test;

import superbook.bean.Category;
import superbook.dao.CategoryDao;

public class CategoryDaoTest {
	private CategoryDao dao = new CategoryDao();
	
	@Test
	public void add() {
		Category c = new Category(); 
		c.setCid(1);
		c.setName("测试");
		dao.add(c);
	}
	
	@Test
	public void delete() {
		dao.delete(1);
	}
	
	@Test
	public void selctname() {
		String a = null;
		a = dao.selectname(1);
		System.out.println(a);
	}
	
	@Test
	public void selectcid() {
		int a ;
		a = dao.selectcid("测试");
		System.out.println(a);
	}
}
