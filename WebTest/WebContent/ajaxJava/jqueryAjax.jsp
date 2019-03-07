<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>AJAX calls using Jquery in Servlet</title>
		<script src="http://code.jquery.com/jquery-latest.js"></script>
		<script>
            $(document).ready(function() {           
				//alert("username after click: "+($('#user').val()));             
                $('#submit').click(function(event) {  
                    var username=$('#user').val();
					//alert("username after click: "+username);
                 	$.get('../jqueryAjax',{user:username},function(responseText) { 
						if(responseText=='void'){
							$("#user").prop("readonly",true);
							$("#submit").prop('disabled', true);
							responseText = "Fuck Off!!!";     
						}
						$('#welcometext').text(responseText);        
                    });
                });
            });
        </script>
	</head>
	<body>
		<form id="form1">
			<h1>AJAX Demo using Jquery in JSP and Servlet</h1>
			Enter your Name:
			<input type="text" id="user" placeholder="enter your name"/>
			<input type="button" id="submit" value="Ajax Submit"/>
			<div id="welcometext">
			</div>
		</form>
	</body>
</html>