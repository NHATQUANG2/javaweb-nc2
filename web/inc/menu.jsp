<%-- 
    Document   : header
    Created on : Apr 19, 2023, 8:24:57 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <div class="logo">
        <a href="HomeServlet">
            <img src="./public/image/dorno.png" />
        </a>
    </div>
    <div class="menu">
        <li class="menu-item"><a href="HomeServlet">Home</a></li>
        <li class="menu-item"><a href="CategoryServlet">Shop</a></li>
        <li class="menu-item"><a href="">Contact Us</a></li>
        <li class="menu-item"><a href="">Blog</a></li>
    </div>
    <div class="other">
        <li>
            <form action="ProductSearchServlet" method="get">
                <input name="search" type="text" placeholder="Tìm kiếm"><i class="fa-solid fa-magnifying-glass" href=""></i>
            </form>
        </li>
        <li><a class="fa-solid fa-cart-shopping" href="CartServlet"></a></li>
        <li>
        <c:if test="${sessionScope.user == null}">
            <a class="fa-solid fa-user" href="LoginServlet"></a>
        </c:if>
        <c:if test="${sessionScope.user != null}">
            <a href="LogoutServlet">Logout</a>
        </c:if>
        </li>
        <li><a  href="DashBoardServlet">Admin</a></li>
    </div>

</header>