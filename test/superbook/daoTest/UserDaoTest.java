package superbook.daoTest;

import org.junit.Test;

import superbook.dao.UserDao;

public class UserDaoTest {

	UserDao userdao = new UserDao();
	@Test 
	public void add() {
		userdao.add("2","nihao");
	}
	
	@Test
	public void delete() {
		userdao.delete(1);
	}
	@Test
	public void select() {
		System.out.println(userdao.selectOpenid(3));
	}
	
	@Test
	public void selectnickName() {
		System.out.println(userdao.selectnickName(3));
	}
}
