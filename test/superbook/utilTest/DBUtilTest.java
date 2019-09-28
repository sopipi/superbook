package superbook.utilTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

import superbook.util.DBUtil;

public class DBUtilTest extends BaseTest{
	DBUtil dbUtil = new DBUtil();
	
	@Test
	public void getConnection() throws SQLException, InterruptedException {
		System.out.println(dbUtil.getConnection());
		Thread A = new Thread() {
			@Override
			public void run() {
				try {
					for(int i = 0; i<10; i++ ) {
						Connection a = DBUtil.getConnection();
						System.out.println(a);

						System.out.println(i+"线程A获得Connection为: " + a);
					}
				}catch (Exception e) {

				}
			}
		};
		Thread B = new Thread() {
			@Override
			public void run() {
				try {
					for(int i = 0; i<100; i++ ) {
						Connection a = dbUtil.getConnection();
						System.out.println(i+"线程B获得Connection为: " + a);
					}
				}catch (Exception e) {
					
				}
			}
		};
		A.start();
		B.start();
		A.sleep(100);
	}
}
