/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package quang.dev.admin;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import quang.dev.data.dao.Database;
import quang.dev.data.dao.DatabaseDao;
import quang.dev.data.dao.OrderDao;
import quang.dev.data.dao.ProductDao;
import quang.dev.data.dao.UserDao;
import quang.dev.data.dao.model.Order;
import quang.dev.data.dao.model.OrderDetail;
import quang.dev.data.dao.model.Product;
import util.Constants;
import util.GetDateTime;

/**
 *
 * @author Dell
 */
public class DashBoardServlet extends BaseAdminServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        int numberUser = userDao.findAll().size();

        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> productList = productDao.findALL();
        int numberProduct = productDao.findALL().size();

        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        int numberOrder = orderDao.findALL().size();
        double total = getTotal();

        request.setAttribute("numberUser", numberUser);
        request.setAttribute("numberProduct", numberProduct);
        request.setAttribute("numberOrder", numberOrder);
        request.setAttribute("total", total);
        request.setAttribute("productList", productList);
        
        List<Order> orderPendingList = orderDao.findByStatus("pending");
        request.setAttribute("orderPendingList", orderPendingList);
        
        //Chart
        List<String> dateList = GetDateTime.getDates(Constants.NUMBER_DAY);
        request.setAttribute("dateList", dateList);
        
        List<Integer> countEachDay = new ArrayList<>();
        for(int i = 0; i < Constants.NUMBER_DAY; i++){
            countEachDay.add(orderDao.countOrderByDay(dateList.get(i)));
        }
        request.setAttribute("countEachDay", countEachDay);
        
        request.getRequestDispatcher("admin/dashboard.jsp").include(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
        private double getTotal() {
        double total = 0;
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        List<Order> orderList = orderDao.findByStatus("finished");
        for (Order order : orderList) {
            List<OrderDetail> orderDetaiList = Database.getInstance().getOrderDetailDao().findByOrder(order.getId());
            total += sum(orderDetaiList);
        }
        return total;
    }

    private double sum(List<OrderDetail> orderDetaiList) {
        double s = 0;
        for (OrderDetail orderDetail : orderDetaiList) {
            s += orderDetail.getQuantity() * orderDetail.getPrice();
        }

        return s;
    
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
