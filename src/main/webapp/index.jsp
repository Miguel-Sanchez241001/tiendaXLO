<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>XLO LIDER EN VENTAS</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
 <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </head>
    <body>
    
        <%--- BARRA DE NAVEGACION----%>
        <nav class="navbar navbar-expand-lg navbar-light bg-light shadow">
            <a class="navbar-brand" href="#">Vista</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto ">


              
          
                    <form class="form-inline my-2 my-lg-0 ">
                        <input class="form-control mr-sm-2 "  type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
                    </form>
          
                </ul>
               
<div id="comandos" class="btn-group" style="display: none">
  <button id="user" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      <%if (session.getAttribute("nombre")!=null) {
     %>    
     <img src="icons/usuario (2).png" alt=""/> <%=session.getAttribute("nombre")%>
     
         <%}%>
         
     
  </button>
  <div class="dropdown-menu dropdown-menu-right">
    <a class="dropdown-item" href="#">Publicar anuncio</a>
    <a class="dropdown-item" href="#">Lista de deseados</a>
    <a class="dropdown-item" href="#">Mensajes</a>
  </div>
</div>
                  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#signinPage">
                    Ingresar</button>

            </div>
        </nav> <br>
                <%--- CARROUSEL----%>

        <div class="mx-auto col-md-12 " >   

            <div id="carouselExampleIndicators" class="carousel slide shadow " data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="img/car_1.jpg" alt="" class="d-block w-100" alt="...">

                    </div>
                    <div class="carousel-item">
                        <img src="img/car_2.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="img/car_3.jpg" class="d-block w-100" alt="...">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>

        <%-- Productos--%>
        <br>
        <div class="mx-auto col-md-12 " >   

        </div>

        <%-- Ventana Modal--%>
        <form>  
        <div class="  modal fade" id="signinPage">
            <div class="modal-dialog">
                <div class="modal-content">

                    <div class="modal-header text-center">
                        <h3 class="modal-title w-100 dark-grey-text font-weight-bold">Sign In</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-lable="close">&times;</button>
                    </div>

                    <div class="modal-body mx-4">
                        <div class="md-form">
                            <input name="usuario" type="text" class="form-control validate">
                            <label data-error="wrong" data-success="right">Usuario</label>
                        </div>

                        <div class="md-form">
                            <input name="clave" type="text" class="form-control validate">
                            <label data-error="wrong" data-success="right">Contraseña</label>
                            <p class="font-small blue-text d-flex justify-content-end">¿No tienes cuenta?<button type="button" class="btn btn-primary" data-dismiss="modal" data-toggle="modal" data-target="#Register">
                                    Registrate </button></p>
                        </div>

                        <div class="text-center mb-3">
                            <button type="button" id="validar" class="btn btn-primary btn-block z-depth-1a" data-dismiss="modal">Ingresar</button>
                        </div>


                    </div>
                </div>
            </div> 
        </div>
        </form>
        <%-- VENTANA DE REGISTRO --%>
        <form>
        <div class=" modal" id="Register">
            <div class="modal-dialog">
                <div class="modal-content">

                    <div class="modal-header text-center">
                        <h3 class="modal-title w-100 dark-grey-text font-weight-bold">Registro de usuario</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-lable="close">&times;</button>
                    </div>

                    <div class="modal-body mx-4">
                        <div class="md-form">
                            <input name="nombre" type="text" class="form-control validate">
                            <label data-error="wrong" data-success="right">Nombres</label>

                            <input name="apellidos" type="text" class="form-control validate">
                            <label data-error="wrong" data-success="right">Apellidos</label>

                            <input name="telefono" type="text" class="form-control validate">
                            <label data-error="wrong" data-success="right">Telefono</label>

                            <input name="email" type="text" class="form-control validate">
                            <label data-error="wrong" data-success="right">Correo Electronico</label>

                        </div>



                        <div class="text-center mb-3">
                            <button type="button" class="btn btn-primary btn-block z-depth-1a" data-dismiss="modal" data-toggle="modal" data-target="#Register2"  >Continuar</button>
                        </div>


                    </div>
                </div>
            </div> 
        </div>
        <%-- VENTANA DE REGISTRO 2--%>

        <div class=" modal" id="Register2">
            <div class="modal-dialog">
                <div class="modal-content">

                    <div class="modal-header text-center">
                        <h3 class="modal-title w-100 dark-grey-text font-weight-bold">Crear Contraseña y usuario</h3>
                        <button type="button" class="close" data-dismiss="modal" aria-lable="close">&times;</button>
                    </div>

                    <div class="modal-body mx-4">
                        <div class="md-form">
                            <input name="usuario" type="text" class="form-control validate">
                            <label data-error="wrong" data-success="right">Nombre de usuario:</label>
                            
                            <input name="clave" type="text" class="form-control validate">
                            <label  data-error="wrong" data-success="right">Contraseña:</label>
                                              </div>



                        <div class="text-center mb-3">
                        </div>

                        <button  id="registrar" type="button"  class="btn btn-primary btn-block z-depth-1a" >Continuar</button>

                    </div>
                </div>
            </div> 
        </div>
        <h1 id="lienzo"></h1>
        </form>
        <!-- jQuery -->
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="js/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script src="js/jquery.js" type="text/javascript"></script>
               <script type="text/javascript">
                   
                   
              document.getElementById("registrar").addEventListener("click",function(){
                 $.post("UsuarioServlet?op=1",$(document.forms[2]).serialize(),function(response){
                     var lienzo=document.getElementById("lienzo");
                     lienzo.innerHTML=response; 
                 });
              },false);
              
              
                 document.getElementById("validar").addEventListener("click",function(){
                 $.post("UsuarioServlet?op=2",$(document.forms[1]).serialize(),function(response){
                     var comandos=document.getElementById("comandos");
                     var user=document.getElementById("user");
                     var usuario=JSON.parse(response);
                     user.innerHTML= ' <img src="icons/usuario (2).png" alt=""/>'+ usuario.nombre+" "+usuario.apellidos;
                     comandos.style.display="block";
                 }); 
              },false);
              
              
               </script>
       
    </body>
</html>
