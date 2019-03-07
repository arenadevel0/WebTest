<%@page import="sun.ajaxJava.practice.jqueryJsonPagination.PaginationDAO"%>
<%
String req=request.getParameter("requestType");
String data="";
 
if(req.equals("countRecords")){
    data=PaginationDAO.countRecords();
}
 
if(req.equals("getRecords")){
    String start=request.getParameter("currentIndex");
    String total=request.getParameter("recordsToFetch");
    data=PaginationDAO.getRecords(start, total);
}
 
out.print(data);
%>