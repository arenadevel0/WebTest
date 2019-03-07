<html>
    <head>
        <title>JSP Pagination Example with Json</title>
        <script src="../js/scripts/jquery-1.12.0.min.js"></script>
    </head>
    
    <body>        
        <script type="text/javascript">
        $(document).ready(function(){
            var totalRecords;
            var recordsPerPage=2;
            var recordsToFetch=recordsPerPage;
            var totalPages;
            var currentPage=1;
            var currentIndex=0;
            
            $.get("ProcessRequest.jsp?requestType=countRecords",function(data){
                var JSONData=JSON.parse(data);
                totalRecords=JSONData.count; 
                totalPages=Math.floor(totalRecords/recordsPerPage);
                
                if(totalRecords%recordsPerPage!=0){
                    totalPages++;
                }
                
                if(totalRecords<recordsPerPage){
                    recordsToFetch=totalRecords%recordsPerPage;
                }
                else{
                    recordsToFetch=recordsPerPage;
                }
                
                $("#page").html("Page "+currentPage+" of "+totalPages);
            });    
            
            $.get("ProcessRequest.jsp?requestType=getRecords&currentIndex="+currentIndex+"&recordsToFetch="+recordsToFetch,function(data){
                var JSONData=JSON.parse(data);
                for(i=0;i<recordsToFetch;++i){
                    $("#div1").append("<p>"+(currentIndex+1)+". "+JSONData.record[i]+"</p>");
                    currentIndex++;
                }
                
                if(currentPage==totalPages){
                    $("#next").hide();
                }
                else{
                    $("#next").show();
                }
                
                if(currentPage==1){
                    $("#back").hide();
                }
                else{
                    $("#back").show();
                }
 
            });
            
 
            
            $("#next").click(function(){
                $("#div1").html("");
                currentPage++;
 
                if(currentPage==totalPages){
                    $("#next").hide();
                    if(totalRecords%recordsPerPage!=0){
                        recordsToFetch=totalRecords%recordsPerPage;
                    }
                    else{
                        recordsToFetch=recordsPerPage;
                    }
                }
                else{
                    $("#next").show();
                    recordsToFetch=recordsPerPage;
                }
                                
                if(currentPage==1){
                    $("#back").hide();
                }
                else{
                    $("#back").show();
                }
 
                $.get("ProcessRequest.jsp?requestType=getRecords&currentIndex="+currentIndex+"&recordsToFetch="+recordsToFetch,function(data){
                    var JSONData=JSON.parse(data);
                    for(i=0;i<recordsToFetch;++i){
                        $("#div1").append("<p>"+(currentIndex+1)+". "+JSONData.record[i]+"</p>");
                        currentIndex++;
                    }
                });
                
                $("#page").html("Page "+currentPage+" of "+totalPages);
 
            });
            
            
            $("#back").click(function(){
                $("#div1").html("");
                currentPage--;
                currentIndex=currentIndex-recordsToFetch-recordsPerPage;
 
                if(currentPage==totalPages){
                    $("#next").hide();
                    recordsToFetch=totalRecords%recordsPerPage;
                }
                else{
                    $("#next").show();
                    recordsToFetch=recordsPerPage;
                }
                
                if(currentPage==1){
                    $("#back").hide();
                }
                else{
                    $("#back").show();
                }
 
                $.get("ProcessRequest.jsp?requestType=getRecords&currentIndex="+currentIndex+"&recordsToFetch="+recordsToFetch,function(data){
                    var JSONData=JSON.parse(data);
                    for(i=0;i<recordsToFetch;++i){
                        $("#div1").append("<p>"+(currentIndex+1)+". "+JSONData.record[i]+"</p>");
                        currentIndex++;
                    }
                });
                
                $("#page").html("Page "+currentPage+" of "+totalPages);
 
            });
 
        });   
        </script>
        
        <div id="div1"></div><br/>
        <button id="back">Back</button>
        <button id="next">Next</button>
        
        <p id="page"></p>
    </body>
</html>