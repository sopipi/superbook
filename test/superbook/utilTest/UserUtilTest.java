package superbook.utilTest;

import org.junit.Test;

import superbook.util.UserUtil;

public class UserUtilTest {
	UserUtil userUtil = new UserUtil();
	
	@Test
	public void getUser() {
		String code = "0000";
		System.out.println(userUtil.getUser(code));
	}
}
