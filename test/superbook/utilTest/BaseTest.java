package superbook.utilTest;


/**
 * 所有测试类的父类方法
 * 开启测试模式，不进行数据库操作，防止污染数据库
 */
import org.junit.Before;
import superbook.util.DBUtil;


public class BaseTest {
	@Before
	public void setUp() {
		// 启用测试模式
		System.out.println("启用测试模式！");
		DBUtil.enableTestMode();
	}
}
