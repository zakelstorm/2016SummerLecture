package service.book;

import java.util.ArrayList;

import DAO.book.BookDAO;
import entity.book.BookEntity;

public class BookService {
	public ArrayList<BookEntity> list(BookEntity entity){
		BookDAO dao = new BookDAO();
		ArrayList<BookEntity> result = dao.select(entity);
		return result;
	}
	
	public ArrayList<BookEntity> listCart(String[] list){
		ArrayList<BookEntity> result = null;
		BookDAO dao = new BookDAO();
		result = dao.select2(list);
		return result;
	}
}
