<%@ page contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<html>
<%@ include file="/WEB-INF/views/common/head.jsp" %>

<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<main>

</main>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
    
</body>
</html>
<html lang="es">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" href="/views/common/favicon.ico" />
    <link rel="stylesheet" href="/styles.css" />
    <title>DeporAmigo</title>
  </head>
  <header class="encabezado">
    <h3>
      DEPORAMIGO <br />
      Haz deporte | Haz amigos
    </h3>
  </header>
  <body>
    <h2 class="login_header">
      <p class="login_text">Inicia sesión o regístrate</p>
    </h2>

    <main>
        <div class="formSection">
      <form class="form" method="post">
          <table>
            <tr>
              <td>
                <label class="formLabel" for="email">Correo electrónico</label>
              </td>
              <td>
                <input
                  id="email"
                  type="email"
                  class="formInput"
                  placeholder="Email con el que te registraste"
                  name="email"
                />
              </td>
            </tr>
        
            <tr>
              <td><label class="formLabel" for="pwd">Contraseña</label></td>
              <td>
                <input
                  id="pwd"
                  type="password"
                  class="formInput"
                  placeholder="Contraseña"
                  name="contraseña"
                />
              </td>
            </tr>
            <tr>    
            
            <td span="2"><button class="submitButton" type="submit">Iniciar sesión</button></td>
        </tr>
        </table>
      </form>
      <div>
        <a class="darkLink" href="/views/usuarios/registrarse.jsp"
          >Darme de alta en el servicio</a
        >
        <br />
        <a class="darkLink" href="pwd.jsp">Olvidé mi contraseña</a>
      </div>
    </main>
    
<footer class="footer">

  <p class="copyright">DeporAmigo - Todos los derechos reservados &copy;</p>
  
  </footer>
  </body>
</html>
