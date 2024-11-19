<%-- 
    Document   : showDataBase
    Created on : Oct 31, 2024, 1:55:02 AM
    Author     : dell
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<!-- Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
   
  <style>
  
  .wrapper {
	margin-top: 80px;
	margin-bottom: 80px;
}

.form-signin {
	max-width: 380px;
	padding: 15px 35px 45px;
	margin: 0 auto;
	background-color: #fff;
	border: 1px solid rgba(0, 0, 0, 0.1);
}

.form-signin .form-signin-heading,
.form-signin .checkbox {
	margin-bottom: 30px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	font-size: 16px;
	height: auto;
	padding: 10px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="text"] {
	margin-bottom: -1px;
	border-bottom-left-radius: 0;
	border-bottom-right-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 20px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
 
  </style> 
    </head>
    <body>
      <h2>Attendance</h2>

    <table class="table">
        <tr>
            <th>Name</th>
            <th>Phone</th>
            <th>Email</th>
        </tr>
        <title>JSP Page</title>
        <%

            try {
                Connection con = null;
                Statement stmt;
                ResultSet rs;
                Connection conn = (Connection) getServletContext().getAttribute("conn");
                // Create SQL query and execute it
                String sql = "SELECT *  FROM  persons.person";
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);


                // Iterate through the result set and display data in table rows
                while (rs.next()) {
                    
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                     String email = rs.getString("email");
        %>
        
    <tr>
  
        <td><%= name%></td>
        <td><%= phone%></td>
        <td><%= email%></td>
    </tr>
    <%
            }
            stmt.cancel();
            rs.close();
            conn.close();
        } catch (Exception e) {

        }
  

     %>

    </table>
</body>
</html>

