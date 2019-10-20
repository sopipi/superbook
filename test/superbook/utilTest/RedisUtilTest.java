package superbook.utilTest;

import org.junit.Test;

import superbook.util.RedisUtil;

public class RedisUtilTest {
	private RedisUtil redis = new RedisUtil();
	@Test
	public void setUser() {
		redis.setUser("1", "1");
	}
	
	
	@Test
	public void existsKey() {
		System.out.println(redis.existsKey("uuid"));
	}
}
