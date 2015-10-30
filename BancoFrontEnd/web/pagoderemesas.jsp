<%@page import="java.util.Iterator"%>
<%@page import="wsg8bancods.Transaccion"%>
<%@page import="java.util.List"%>
<%@page import="com.usac.sa.g8.banco.utils.Reportes"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SuperBancos - Pago de remesas</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="css/modern-business.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">SuperBancos</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="about.html">Acerca de SuperBancos</a>
                        </li>
                        <li>
                            <a href="services.html">Servicios</a>
                        </li>
                        <li>
                            <a href="contact.html">Contactenos</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Otras Paginas<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="faq.html">FAQ</a>
                                </li>
                                <li>
                                    <a href="404.html">404</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

        <!-- Page Content -->
        <ul class="nav nav-tabs">
            <li class="active"><a href="#Efectivo" data-toggle="tab" aria-expanded="true">Pago de remesas en efectivo</a></li>
            <li class=""><a href="#Prestamo" data-toggle="tab" aria-expanded="false">Consultar Estado de Cuenta</a></li>
            <li class=""><a href="#Cuenta" data-toggle="tab" aria-expanded="false">Consultar Prestamos</a></li>
        </ul>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade active in" id="Efectivo">
                <form class="form-group">
                    <fieldset>
                        <legend>Ingrese los datos necesarios</legend>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-2 control-label">Numero Remesa</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="quien_envia" placeholder="Remesa">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-2 control-label">Numero de Remesadora</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="quien_recive" placeholder="Remesadora">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-2 control-label">Monto a Pagar</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="quien_recive" placeholder="Monto">
                            </div>
                        </div>
                        <div class="form-group">

                        </div>
                        <div class="form-group">
                            <div class="col-lg-10 col-lg-offset-2">
                                <button type="reset" class="btn btn-default">Cancel</button>
                                <button type="submit" class="btn btn-primary">Enviar</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
            <div class="tab-pane fade active in" id="Prestamo">
                <h1> Consulta de Cuentas </h1>
                <fieldset>
                    <legend>Ingrese los datos necesarios</legend>
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-2 control-label">Numero de Cuenta</label>
                        <div class="col-lg-10">
                            <!-- <input type="text" class="form-control" id="quien_envia" placeholder="Cod. Cuenta"> -->
                        </div>
                    </div>
                    <div class="form-group">

                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <form action="pagoderemesas.jsp" method="POST">
                                <!-- <input type="text" class="form-control" id="quien_envia" placeholder="Cod. Cuenta"> -->
                                Codigo Cuenta:
                                <input type="text" name="cod_cuenta">
                                <!-- <button type="reset" class="btn btn-default">Cancel</button> -->
                                <input type="submit" value="Enviar" id="enviar">
                                <%
                                    String resultado = request.getParameter("enviar");
                                        //int id = 1;
                                    if (resultado != null) {

                                        int id = Integer.parseInt(request.getParameter("cod_cuenta"));
                                        out.println(id);
                                        Reportes r = new Reportes();
                                        List<Transaccion> estados = r.getEstadoDeCuenta(id);
                                        Iterator<Transaccion> i = estados.iterator();
                                        Transaccion t;
                                        while (i.hasNext()) {
                                            t = i.next();
                                            out.println("Fecha:" + t.getFecha());
                                            out.println("" + t.getIdCuenta());
                                        }
                                    }
                                %>
                            </form>



                        </div>
                    </div>
                </fieldset>
            </div>
            <div class="tab-pane fade active in" id="Cuenta">
                <h1> Consulta de Prestamos. </h1>
                <fieldset>
                    <legend>Ingrese los datos necesarios</legend>
                    <div class="form-group">
                        <label for="inputEmail" class="col-lg-2 control-label">Numero de Prestamo</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="quien_recive" placeholder="Cod. Prestamo">
                        </div>
                    </div>
                    <div class="form-group">
                        <!--EL OTRO INTERADOR PERO DE ABONOS-->
                    </div>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <button type="reset" class="btn btn-default">Cancel</button>
                            <button type="submit" class="btn btn-primary">Enviar</button>
                        </div>
                    </div>
                </fieldset>
            </div>
        </div>
        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
