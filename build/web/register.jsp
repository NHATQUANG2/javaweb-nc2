<%-- 
    Document   : register
    Created on : May 12, 2023, 4:00:37 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
        <link rel="stylesheet" href="./public/css/style.css">
        <link
            href="https://fonts.googleapis.com/css2?family=Open+Sans&family=Oswald:wght@300&family=Poppins:ital,wght@0,400;0,500;1,300&family=Roboto&display=swap"
            rel="stylesheet">
        <title>Register</title>
    </head>

    <body>
        <!-- <--------top-header-------->
        <%@include file="./inc/menu.jsp" %>
        <!------------ section-------- -->
        <div class="login-content">
            <div class="login-head">
                <div class="home-item">
                    <ul>
                        <li>
                            <a class="home" href="HomeServlet">
                                <span><i class="fa-solid fa-house-chimney"></i></span>
                            </a>
                        </li>
                        <li class="shop-go">
                            <i class="fa-solid fa-chevron-right"></i>
                            <label class="shop">Register</label>
                        </li>
                    </ul>
                </div>
            </div>
            <!------- content----- -->
            <div class="wrapper">
                <div class="login-product">
                    <h2>Register</h2>
                    <c:if test="${sessionScope.errors != null}">
                        <p>
                            ${sessionScope.errors}
                            <c:remove var="errors" />
                        </p>
                    </c:if>

                    <form action="RegisterServlet" method="post">
                        <div class="group-email">
                            <span><i class="fa-solid fa-envelope"></i></span>
                            <input type="text" name="email" value="" placeholder="Email">

                        </div>
                        <div class="group-password">
                            <span><i class="fa-solid fa-unlock"></i></span>
                            <input type="password" name="password" value="" placeholder="Vui lòng nhập password">
                        </div>
                        <div class="group-password">
                            <span><i class="fa-solid fa-unlock"></i></span>
                            <input type="password" name="password" value="" placeholder="Vui lòng xác nhận password">
                        </div>
                       
                        <div class="register">
                            <span>If you have an account, please
                            </span>
                            <a href="LoginServlet">
                                <strong>Login</strong>

                            </a>
                        </div>
                        <div class="form-summit">
                            <button type="submit" class="login-btn">Create</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
        <!-- Footer -->
        <%@include file="./inc/footer.jsp" %>
        <!-- Footer -->
    </body>

</html>

