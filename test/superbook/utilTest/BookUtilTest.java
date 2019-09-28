package superbook.utilTest;

import org.junit.Test;

import superbook.util.BookUtil;

public class BookUtilTest {
	BookUtil bookUtil = new BookUtil();
	@Test
	public void getBook() {
		String isbn = "9787208061644";
		System.out.println(bookUtil.getBook(isbn).toString());
	}
}
