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
  <body>
    <header class="encabezado">
      <h3>
        DEPORAMIGO <br />
        Haz deporte | Haz amigos
      </h3>
    </header>
    <nav>
      <ul>
        <li>
          <a href="/index.jsp">
            <object
              type="image/svg+xml"
              data="/src/salir.svg"
              class="lightIcon"
              alt="salir de la aplicación"
              style="pointer-events: none"
            ></object>
          </a>
        </li>

        <li>
          <a href="/views/actividades/buscar.jsp">
            <object
              type="image/svg+xml"
              data="/src/search.svg"
              class="lightIcon"
              alt="Buscar actividades"
              style="pointer-events: none"
            ></object>
          </a>
        </li>
        <li>
          <a href="/views/usuarios/private/ver.jsp">
            <object
              type="image/svg+xml"
              data="/src/account.svg"
              class="lightIcon"
              style="pointer-events: none"
            ></object>
          </a>
        </li>
      </ul>
    </nav>
    <main class="main">
      <h1>Buscar actividades</h1>

      <form class="form" method="post" action="">
        <table>
          <tr>
            <td>
              <label for="desplDeportes">Tipo de actividad</label>
            </td>
          </tr>
          <tr>
            <td>
              <select name="desplDeportes" id="desplDeportes">
                <option value="bádminton">Bádminton</option>
                <option value="baloncesto">Baloncesto</option>
                <option value="ciclismo">Ciclismo</option>
                <option value="fútbol-7">Fútbol 7</option>
                <option value="fútbol">Fútbol</option>
                <option value="patinaje">Patinaje</option>
                <option value="running">Running</option>
                <option value="senderismo">Senderismo</option>
                <option value="voleyball">Voleyball</option>
                <option value="otros">Otros (añadir en comentarios)</option>
              </select>
            </td>
          </tr>
          <tr>
            <td><label class="formLabel" for="fecha">Fecha y hora</label></td>
          </tr>
          <tr>
            <td>
              <input
                id="fecha"
                type="datetime-local"
                class="formInput"
                name="fecha"
              />
            </td>
          </tr>
          <tr>
            <td>
              <button class="lightButton" type="reset">Borrar criterios</button>
            </td>
          </tr>
          <tr>
            <td>
              <a href="/views/actividades/mostrar.jsp" target="_self">
                <button class="darkButton">Buscar actividades</button>
              </a>
            </td>
          </tr>
        </table>
      </form>

      <div class="resultsDiv"></div>
    </main>

    <footer class="footer">
      <p class="copyright">DeporAmigo - Todos los derechos reservados &copy;</p>
    </footer>
  </body>
</html>
