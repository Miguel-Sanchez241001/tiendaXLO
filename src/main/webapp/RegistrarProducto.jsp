<%-- 
    Document   : RegistrarProducto
    Created on : 31 oct. 2020, 20:53:10
    Author     : Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <form action="producto" method="POST" enctype="multipart/form-data">  
            
        <div class="custom-file">
        <input name="foto" type="file" class="custom-file-input" id="customFile">
        <label class="custom-file-label" for="customFile">Choose file</label>
        
        
        </div>
            
            
            
            <input name="producto" class="form-control" type="text" placeholder="Nombre de producto">
            <input name="descripcion" class="form-control" type="text" placeholder="Descripcion">
            <input name="costo" class="form-control" type="text" placeholder="Costo">
            <input name="categoria"   class="form-control" type="text" placeholder="Categoria">
            <input type="submit" name="op" value="1" >
        </form>

    </body>
</html>
