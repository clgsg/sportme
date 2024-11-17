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
            <a href="/index.html"> 
             <object type="image/svg+xml" data="/src/salir.svg" class="lightIcon" alt="salir de la aplicación" style="pointer-events: none;">
              </object>
            </a>
              </li>
          </li>
          <li>
            <a href="/views/actividades/buscar.html">
              <object type="image/svg+xml" data="/src/search.svg" class="lightIcon" alt="Buscar actividades" style="pointer-events: none;">
                
              </object>
              
          
          </a></li>
              <li><a href="/views/usuarios/private/ver.html">
                  <object type="image/svg+xml" data="/src/account.svg" class="lightIcon"  style="pointer-events: none;"></object>
                </a>
              
        </ul>
  </nav>

    <main>
      <h1>Crear actividad</h1>
      <form class="form" method="post" action="">
        <table>
          <tr>
            <td>
              <label class="formLabel" for="desplDeportes"
                >Tipo de actividad</label
              >
            </td>
          </tr>
          <tr>
            <td>
              <select name="desplDeportes" id="desplDeportes" size="1" required>
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
            <td>
              <label class="formLabel" for="fecha">Fecha y hora</label>
            </td>
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
              <label class="formLabel" for="lugar">Lugar</label>
            </td>
          </tr>
          <tr>
            <td>
              <select name="lugar" id="lugar" size="1" required>
                <option selected="selected">Elige un lugar</option>
                <option value="PM_PilarCalle">Elige un lugar</option>
                <option value="SporFit">Elige un lugar</option>
                <option value="PabellonEnriqueSerichol">Elige un lugar</option>
                <option value="PolidMatute">Elige un lugar</option>
                <option value="PabellonRamirez">Elige un lugar</option>
              </select>
            </td>
          </tr>
          <tr>
            <td>
              <label class="formLabel" for="partMin">Part. mín.</label>
            </td>
          </tr>
          <tr>
            <td>
              <input
                id="partMin"
                type="text"
                class="formInput"
                placeholder="0"
                name="partMin"
              />
            </td>
          </tr>
          <tr>
            <td>
              <label class="formLabel" for="partMax">Part. máx.</label>
            </td>
          </tr>
          <tr>
            <td>
              <input
                id="partMax"
                type="text"
                class="formInput"
                placeholder="0"
                name="partMax"
              />
            </td>
          </tr>
          <tr>
            <td>
              <label class="formLabel" for="comentariosBox">Comentarios</label>
            </td>
          </tr>
          <tr>
            <td>
              <textarea
                id="comentariosBox"
                name="comentarios"
                rows="5"
                cols="40"
                placeholder="¿Algo que añadir? (Ejemplo: Falta equipamiento, se mantiene en caso de lluvia, etc.)"
              ></textarea>
            </td>
          </tr>
          <tr>
            <td>
              <a href=""><button class="lightButton">Limpiar formulario</button></a>
            </td>
          </tr>
          <tr>
            <td>
                <a href="/views/actividades/mostrar.html">
                <button class="darkButton">Crear actividad</button>
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