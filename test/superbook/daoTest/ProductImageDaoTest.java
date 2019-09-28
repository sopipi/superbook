package superbook.daoTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import superbook.bean.ProductImage;
import superbook.dao.ProductImageDao;
import superbook.util.DBUtil;

public class ProductImageDaoTest {
	private ProductImageDao dao = new ProductImageDao();
	
	@Test 
	public void add () {
		ProductImage img = new ProductImage();
		img.setType("middle");
		img.setPid(1);
		dao.add(img);
	}
	
	@Test
	public void selectType() {
		int pid = 1;
		List<String> list = new ArrayList<>();
 		list = dao.selectType(pid);
 		for(String a : list) {
 			System.out.println(a);
 		}
	}
	
	@Test
	public void delete() {
		dao.delete(1);
	}
	
	
}
