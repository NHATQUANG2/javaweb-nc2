package quang.dev;


import quang.dev.data.dao.CategoryDao;
import quang.dev.data.dao.OrderDao;
import quang.dev.data.dao.OrderDetailDao;
import quang.dev.data.dao.ProductDao;
import quang.dev.data.dao.UserDao;
import quang.dev.data.dao.CategoryDao;
import quang.dev.data.dao.impl.CategoryDaoImpl;
import quang.dev.data.dao.impl.OrderDaoImpl;
import quang.dev.data.dao.impl.OrderDetailDaoImpl;
import quang.dev.data.dao.impl.ProductDaoImpl;
import quang.dev.data.dao.impl.UserDaoImpl;

import quang.dev.data.dao.model.Category;
import quang.dev.data.dao.model.Order;
import quang.dev.data.dao.model.OrderDetail;
import quang.dev.data.dao.model.Product;
import quang.dev.data.dao.model.User;


public class MainApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//User
		UserDao userDao = new UserDaoImpl();
		User user = new User("quang@gmail.com", "123456", "admin");
		userDao.insert(user);
		
		//category
//		CategoryDao categoryDao = new CategoryDaoImpl();
//		Category category = new Category("AoNam", "https://localhost/public/img1.jpg");
//		categoryDao.insert(category);
		
		//Order
//		OrderDao orderDao = new OrderDaoImpl();
//		Order order = new Order("20", "hello", 13);
//		orderDao.insert(order);
		
		//Orderdetail
//		 OrderDetailDao orderdetailDao = new OrderDetailDaoImpl();
//		 OrderDetail orderdetail = new OrderDetail(16, 6, 4, 100);
//		 orderdetailDao.insert(orderdetail);
 
//		//Product
//		ProductDao productDao = new ProductDaoImpl();
//		Product product = new Product("ao moi", "ba mua", "http://localhost:8080/Eshop/public/images/product-12.jpg", 12, 5, 4, 16);
//		productDao.insert(product);
//			
//		System.out.println("success");
		
	}	
}
