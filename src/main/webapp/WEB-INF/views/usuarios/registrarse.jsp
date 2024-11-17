<%@ page contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>


<html>
<%@ include file="/WEB-INF/views/common/head.jsp" %>

<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<main>

</main>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
    
</body>
</html>


<html lang="es">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="shortcut icon" href="/views/common/favicon.ico" />
    <link rel="stylesheet" href="../../styles.css" />
    <title>DeporAmigo</title>
  </head>
  <body>
    <header class="encabezado">
      <h3>
        DEPORAMIGO <br />
        Haz deporte | Haz amigos
      </h3>
    </header>
    <main>
      <h1>Registrarse como usuario</h1>
      <form class="form" method="post">
        <table>
          <tr>
            <td>
              <label class="formLabel" for="email">Correo electrónico</label>
            </td>
          </tr>

          <tr>
            <td>
              <input
                id="email"
                type="email"
                class="formInput"
                placeholder="Correo de usuario"
                name="correo"
              />
            </td>
          </tr>
          <tr>
            <td>
              <label class="formLabel" for="apodo">Apodo (usuario)</label>
            </td>
          </tr>

          <tr>
            <td>
              <input
                id="apodo"
                type="text"
                class="formInput"
                placeholder="Apodo (nombre de usuario)"
                name="apodo"
              />
            </td>
          </tr>
          <tr>
            <td>
              <label class="formLabel" for="nombre">Nombre</label>
            </td>
          </tr>

          <tr>
            <td>
              <input
                id="nombre"
                type="text"
                class="formInput"
                placeholder="Nombre"
                name="nombre"
              />
            </td>
          </tr>

          <tr></tr>
          <tr>
            <td>
              <label class="formLabel" for="apellido1">Primer apellido</label>
            </td>
          </tr>

          <tr>
            <td>
              <input
                id="apellido1"
                type="text"
                class="formInput"
                placeholder="Primer apellido"
                name="apellido1"
              />
            </td>
          </tr>
          <tr>
            <td>
              <label class="formLabel" for="apellido2">Segundo apellido</label>
            </td>
          </tr>

          <tr>
            <td>
              <input
                id="apellido2"
                type="text"
                class="formInput"
                placeholder="Segundo apellido"
                name="apellido2"
              />
            </td>
          </tr>

          <tr>
            <td>
              <label class="formLabel" for="pwd">Contraseña</label>
            </td>
          </tr>

          <tr>
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
            <td>
              <a href="#"
                ><button class="lightButton" type="reset">
                  Limpiar formulario
                </button></a>
            </td>
          </tr>
          <tr>
            <td>
              <a href="/views/actividades/buscar.html">
                <button class="darkButton" type="submit">Registrame</button>
              </a>
            </td>
          </tr>
        </table>
      </form>
    </main>

    <footer class="footer">
      <p class="copyright">DeporAmigo - Todos los derechos reservados &copy;</p>
    </footer>
  </body>
</html>
