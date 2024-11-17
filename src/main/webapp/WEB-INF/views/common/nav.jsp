<%@ page contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<nav>
    <ul>
      <li>
        <a href="/index.html"><s:message code="nav.saludo"/>
          <object
            type="image/svg+xml"
            data="/src/main/webapp/icon/salir.svg"
            class="lightIcon"
            alt="salir de la aplicación"
            style="pointer-events: none"
          ></object>
        </a>
      </li>
      <li>
        <a href="/views/actividades/buscar.html"><s:message code="nav.buscar"/>
          <object
            type="image/svg+xml"
            data="/src/main/webapp/icon/search.svg"
            class="lightIcon"
            alt="Buscar actividades"
            style="pointer-events: none"
          ></object>
        </a>
      </li>
      <li>
        <a href="/views/usuarios/private/ver.html"><s:message code="nav.ver"/>
          <object
            type="image/svg+xml"
            data="/src/main/webapp/icon/account.svg"
            class="lightIcon"
            style="pointer-events: none"
          ></object>
        </a>
      </li>
    </ul>
  </nav>