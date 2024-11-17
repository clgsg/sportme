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

  <h1>Editar actividad</h1>
  <form class="form" method="post" action="">
    <table>
      <tr>
        <td>
          <label class="disabledFormLabel" for="tipoActividad"
            >Tipo de actividad</label
          >
        </td>
      </tr>
      <tr>
        <td>
          <input
            class="disabledField"
            name="tipoActividad"
            id="tipoActividad"
            disabled
            value="Deporte seleccionado"
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
          <select
            name="lugar"
            id="lugar"
            placeholder="Elige un lugar"
            size="1"
          >
            <!-- TODO: añadir foreach que recupere instalaciones en el desplegable  -->
            <option value="P.M. Alejandra Valle">
              P.M. Alejandra Valle
            </option>
            <option value="DeporFit">DeporFit</option>
            <option value="P.M. Santa Cecilia">P.M. Santa Cecilia</option>
            <option value="P.M. Vallelado">P.M. Vallelado</option>
            <option value="otro">Otro (especificar en comentarios)</option>
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
            cols="50"
            placeholder="¿Algo que añadir? (Ejemplo: Falta equipamiento, se mantiene en caso de lluvia, etc.)"
          ></textarea>
        </td>
      </tr>
      <tr>
        <td>
          <button class="lightButton">Limpiar formulario</button>
        </td>
      </tr>
      <tr>
        <td>
          <button class="darkButton">Guardar cambios</button>
        </td>
      </tr>
      <tr>
        <td>
          <button class="redButton">Eliminar actividad</button>
        </td>
      </tr>
    </table>
  </form>




</main>
<%@ include file="WEB-INF/views/common/footer.jsp" %>
    
</body>
</html>

