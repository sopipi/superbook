package superbook.daoTest;

import org.junit.Test;

import superbook.bean.Box;
import superbook.dao.BoxDao;

public class BoxDaoTest {
	private BoxDao boxdao = new BoxDao();
	
	@Test
	public void add() {
		System.out.println("sucess");
		Box box = new Box();
		box.setMid(1);
		box.setSize(4);
		box.setBoxState(33);
		System.out.println("Seccess");
		boxdao.add(box);
		System.out.println("Seccess");
	}
	
	@Test
	public void delete() {
		boxdao.delete(2);
		System.out.println("Success");
		
	}
	
	@Test
	public void selectMid() {
		System.out.println(boxdao.selectMid(3));
	}
	
	@Test
	public void selectBoxState() {
		System.out.println(boxdao.selectBoxState(3));
	}
	
	@Test
	public void selectSize() {
		System.out.println(boxdao.selectSize(3));
	}
	
	@Test
	public void changeState() {
		boxdao.changeState(3,222);
	}
	
}
