<%@ page import="fpt.aptech.t2009m1helloworld.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.t2009m1helloworld.controller.product.client.ListProductClientServlet" %>
<%@ page import="com.example.t2009m1helloworld.entity.Product" %>
<%--
  Created by IntelliJ IDEA.
  User: 🤡🤡🤡
  Date: 06/06/2022
  Time: 10:08 CH
  To change this template use File | Settings | File Templates.
--%>
<% List<Product> products = (List<Product>) request.getAttribute("products"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h1>List Product</h1>
<ul>
    <%for (Product product: products){%>
        <li>
            <%=product.toString()%> &nbsp;
            <a href="/shopping-cart/add?productId=<%=product.getId()%>&quantity=1">Add to cart</a>
        </li>
    <%}%>
</ul>
</body>
</html>
