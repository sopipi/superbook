package superbook.daoTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import superbook.bean.Book;
import superbook.dao.BookDao;
import superbook.util.BookUtil;

public class BookDaoTest {
	private BookDao bookdao =new BookDao();
	
	@Test
	public void add() {
		String isbn = "9787208061644";
		Book book = new BookUtil().getBook(isbn);
		System.out.println(book.toString());
		bookdao.add(book);
	}
	
	@Test 
	public void select() {
		String isbn = "9787208061644";
		Book book = bookdao.selectByIsbn(isbn);
		System.out.println(book.toString());
	}
	@Test
	public void selectByTitle() {
		List<Book> list = new ArrayList<>();
		list = bookdao.selectByTitle("追风筝的人");
		for(Book b: list) {
			System.out.println(b.toString());
		}
	}
}
