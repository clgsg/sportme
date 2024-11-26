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
    <main>
      <h1>Resultado de tu búsqueda</h1>
    </main>

    <footer class="footer">
      <p class="copyright">DeporAmigo - Todos los derechos reservados &copy;</p>
    </footer>
  </body>
</html>
