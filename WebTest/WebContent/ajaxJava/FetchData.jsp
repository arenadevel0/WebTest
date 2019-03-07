<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>AJAX JsonArray Example</title>
		<link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
		<style type="text/css">
			table, td, th
			{
			border:1px solid green;
			font-family: 'Oxygen', sans-serif;
			}
			th
			{
			background-color:green;
			color:white;
			}
			body
			{
			 text-align: center;
			}
			.container
			{
			 margin-left: auto;
			 margin-right: auto;
			 width: 40em;
			}
		</style>
		<script src="../js/scripts/jquery-1.12.0.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
			 $("#tablediv").hide();
			     $("#showTable").click(function(event){
			           $.get('../GetCountry',function(responseJson) {
			            if(responseJson!=null){
			                $("#countrytable").find("tr:gt(0)").remove();
							console.log("table1: "+table1);
			                var table1 = $("#countrytable");
							console.log("table1: "+table1);
			                $.each(responseJson, function(key,value) { 
			                     var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
									rowNew.children().eq(0).text(value['recNo']); 
			                        rowNew.children().eq(1).text(value['code']); 
			                        rowNew.children().eq(2).text(value['name']); 
			                        rowNew.children().eq(3).text(value['continent']); 
			                        rowNew.children().eq(4).text(value['region']); 
			                        rowNew.children().eq(5).text(value['population']); 
			                        rowNew.children().eq(6).text(value['capital']); 
			                        rowNew.appendTo(table1);
			                });
			                }
			            });
			            $("#tablediv").show();          
			  });      
			});
		</script>
	</head>
	<body class="container">
	<h1>AJAX Retrieve Data from Database in Servlet and JSP using JSONArray</h1>
	<input type="button" value="Show Table" id="showTable"/>
	<div id="tablediv">
	<table cellspacing="0" id="countrytable"> 
	    <tr> 
	        <th scope="col">Code</th> 
	        <th scope="col">Name</th> 
	        <th scope="col">Continent</th> 
	        <th scope="col">Region</th> 
	        <th scope="col">Population</th> 
	        <th scope="col">Capital</th>          
	    </tr> 
	</table>
	</div>
	</body>
</html>