package superbook.daoTest;

import org.junit.Test;

import superbook.dao.UserDao;

public class UserDaoTest {

	UserDao userdao = new UserDao();
	@Test 
	public void add() {
		userdao.add("2","nihao","qweqwe");
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
	@Test
	public void selectUser() {
		System.out.println(userdao.selectUser("2").toString());
	}
	@Test 
	public void	selectuid() {
		System.out.println(userdao.selectuid("2"));
	}
	
	@Test 
	public void	selectUid() {
		System.out.println(userdao.selectUid("fafa"));
	}
	
	
	@Test 
	public void	selectUuid() {
		System.out.println(userdao.selectUuid(1));
	}
}
