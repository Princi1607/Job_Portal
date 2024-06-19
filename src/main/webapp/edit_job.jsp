<%@page import="com.entity.jobs"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.JobDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Jobs</title>
    <%@include file="all_component/all_css.jsp" %>
</head>
<body style="background-color: #f0f1f2;">
<c:if test="${userobj.role ne 'admin' }">
     <c:redirect url="login.jsp"></c:redirect>
     </c:if>
    <%@include file="all_component/navbar.jsp"%>
    <div class="col-md-10 offset-md-1">
        <div class="card">
            <div class="card-body">
                <div class="text-center text-success">
                    <i class="fas fa-user-friends fa-3x"></i>
                    <%
                    int id=Integer.parseInt(request.getParameter("id"));
                    JobDAO dao=new JobDAO(DBConnect.getConn());
                    jobs j=dao.getJobById(id);%>
                    
                   
                    <h5>Edit Jobs</h5>
                </div>
                <form action="update" method="post">
                <input type="hidden" value="<%=j.getId()%>" name="id">
                    <div class="form-group">
                        <label for="title">Enter Id</label>
                        <input type="number" name="id" required class="form-control">
                    </div>
                    
                    <div class="form-group">
                        <label for="title">Enter Title</label>
                        <input type="text" name="title" required class="form-control" value="<%=j.getTitle()%>">
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="location">Location</label>
                            <select name="location" class="custom-select" id="inlineFormCustomSelectPref">
                                <option value="<%=j.getLocation()%>"><%=j.getLocation() %></option>
                                <option value="Odisha">Odisha</option>
                                <option value="Jharkhand">Jharkhand</option>
                                <option value="Gujarat">Gujarat</option>
                                <option value="Bhubaneswar">Bhubaneswar</option> <!-- Corrected spelling -->
                                <option value="Delhi">Delhi</option>
                                <option value="Bangalore">Bangalore</option> <!-- Corrected spelling -->
                                <option value="Chennai">Chennai</option>
                                <option value="Hyderabad">Hyderabad</option>
                            </select>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="category">Category</label>
                            <select class="custom-select" id="inlineFormCustomSelectPref" name="category">
                                <option value="<%= j.getCategory() %>"><%= j.getCategory() %></option>

                                <option value="IT">IT</option>
                                <option value="Developer">Developer</option>
                                <option value="Banking">Banking</option>
                                <option value="Engineer">Engineer</option>
                                <option value="Teacher">Teacher</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="status">Status</label> <!-- Added "for" attribute -->
                        <select class="form-control" name="status"> <!-- Corrected class attribute -->
                            <option class="Active" value="<%=j.getStatus() %>"><%=j.getStatus() %></option>
                            <option value="Active">Active</option>
                            <option value="Inactive">Inactive</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="desc">Enter Description</label>
                        <textarea required rows="6" cols="40" name="desc" class="form-control"><%=j.getDescription()%></textarea>
                    </div>
                    <button class="btn btn-success" type="submit">Update Job</button> <!-- Added "type" attribute -->
                </form>
            </div>
        </div>
    </div>
</body>
</html> 
