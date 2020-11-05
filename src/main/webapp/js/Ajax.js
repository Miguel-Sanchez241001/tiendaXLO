

function registrar(){
            $.ajax({
             url:"${pageContext.request.contexPath}/UserServlet",
             type:"GET",
             dataType:"JSON",
             succes:function(data){}
                alert(data.nombre);
            });
            
}
        