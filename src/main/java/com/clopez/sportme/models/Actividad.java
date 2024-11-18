package com.clopez.sportme.models;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ACTIVIDADES")
@NamedNativeQueries({
		@NamedNativeQuery(
				name = "Actividades.getActividadById", 
				query = "select d.DEPORTE, a.FECHA, i.NOMBRE from ACTIVIDADES a "
				+ "JOIN DEPORTES d on d.ID_DEPORTE= a.FK_DEPORTE "
				+ "join INSTALACIONES i on i.ID_INSTALACION = a.FK_INSTALACION "
				+ "WHERE a.id_actividad = :idActividad AND a.FECHA > SYSDATE; "),
		@NamedNativeQuery(
				name = "Actividades.getAllActividades", 
				query = "select d.DEPORTE, a.FECHA, i.NOMBRE from ACTIVIDADES a "
				+ "JOIN DEPORTES d on d.ID_DEPORTE= a.FK_DEPORTE "
				+ "join INSTALACIONES i on i.ID_INSTALACION = a.FK_INSTALACION "
				+ "WHERE a.FECHA > SYSDATE; "),
		@NamedNativeQuery(
				name = "Actividades.getActividadesByTypeAndDate", 
				query = "select d.DEPORTE, a.FECHA, i.NOMBRE from ACTIVIDADES a "
				+ "JOIN DEPORTES d on d.ID_DEPORTE= a.FK_DEPORTE"
				+ "join INSTALACIONES i on i.ID_INSTALACION = a.FK_INSTALACION"
				+ "where d.deporte = :deporte and a.fecha= :fecha  "
				+ "and a.FECHA > SYSDATE; "),
		@NamedNativeQuery(
				name = "Actividades.getActividadesByType", 
				query = "select d.DEPORTE, a.FECHA, i.NOMBRE from ACTIVIDADES a  "
				+ " JOIN DEPORTES d on d.ID_DEPORTE= a.FK_DEPORTE "
				+ " join INSTALACIONES i on i.ID_INSTALACION = a.FK_INSTALACION "
				+ " where d.deporte = :deporte  "
				+ " and a.FECHA > SYSDATE; "),
		@NamedNativeQuery(
				name = "Actividades.getActividadesByDate", 
				query = "select d.DEPORTE, a.FECHA, i.NOMBRE from ACTIVIDADES a "
				+ " JOIN DEPORTES d on d.ID_DEPORTE= a.FK_DEPORTE "
				+ " join INSTALACIONES i on i.ID_INSTALACION = a.FK_INSTALACION "
				+ "  where a.fecha= :fecha;"),
		@NamedNativeQuery(
				name = "Actividades.getActividadesCreatedByUser", 
				query = "select d.DEPORTE, a.FECHA, i.NOMBRE from ACTIVIDADES a  "
				+ "JOIN DEPORTES d on d.ID_DEPORTE= a.FK_DEPORTE "
				+ "join INSTALACIONES i on i.ID_INSTALACION = a.FK_INSTALACION "
				+ "where a.fk_usuario = :idUsuario "
				+ "or a.fk_usuario= (select id_usuario from usuarios where apodo = :apodo) "
				+ "and a.FECHA > SYSDATE; "),
		@NamedNativeQuery(
				name = "Actividades.getParticipantNicks", 
				query = "select u.APODO from usuarios u "
				+ "join PARTICIPANTES p on p.FK_USUARIO= u.ID_USUARIO "
				+ "join ACTIVIDADES a on a.ID_ACTIVIDAD = p.FK_ACTIVIDAD "
				+ "where a.ID_ACTIVIDAD = :idActividad;"),
		@NamedNativeQuery(
				name = "Actividades.countParticipantsByIdActividad", 
				query = "select COUNT(*)\r\n" + //
				"from usuarios u\r\n" + //
				"join PARTICIPANTES p on p.FK_USUARIO= u.ID_USUARIO\r\n" + //
				"join ACTIVIDADES a on a.ID_ACTIVIDAD = p.FK_ACTIVIDAD\r\n" + //
				"group by a.ID_ACTIVIDAD\r\n" + //
				"having a.ID_ACTIVIDAD = :idActividad;"),
		@NamedNativeQuery(
				name = "Actividades.createActividad", 
				query = "INSERT INTO ACTIVIDADES A ( FK_USUARIO, FK_DEPORTE, FK_INSTALACION, FECHA, COMENTARIOS) "
					+ " VALUES (:idUsuario, :idDeporte, :idInstalacion, :fecha, :comentarios);"),
		@NamedNativeQuery(
				name = "Actividades.updateTimestampActividad", 
				query = "UPDATE ACTIVIDADES SET FECHA = :nuevaFecha WHERE id_actividad = :idActividad"),
		@NamedNativeQuery(
				name = "Actividades.updateTimestampActividad", 
				query = "DELETE FROM ACTIVIDADES WHERE id_actividad = :idActividad")
})
public class Actividad implements Serializable {
	private static final long serialVersionUID = -6567297175530353288L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "idActividad", sequenceName = "ACTIVITYIDSEQUENCE")
	@Column(name = "id_actividad")
	private int idActividad;

	@Column(name = "fk_usuario", nullable = false)
	private int usuarioCreadorFk; // Creador de la actividad

	@Column(name = "fk_deporte", nullable = false)
	private int deporteFk;

	@Column(name = "fk_instalacion", nullable = false)
	private int instalacionFk;

	@Column(name = "min_participantes")
	private int minParticipantes;

	@Column(name = "max_participantes")
	private int maxParticipantes;

	@Column(name = "comentarios")
	@Size(max = 400)
	private String comentarios;

	@Column(name = "fecha", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaActividad;

	@Column(name = "fecha", nullable = false)
	@Temporal(TemporalType.TIME)
	private Time horaActividad;

	@ManyToOne
	@JoinColumn(name = "id_instalacion")
	private Instalacion instalacion;

	@ManyToOne
	@JoinColumn(name = "id_deporte")
	private Deporte deporte;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario creador;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "PARTICIPANTES", 
		joinColumns = @JoinColumn(name = "fk_actividad"), 
		inverseJoinColumns = @JoinColumn(name = "fk_usuario"))
	private List<Usuario> participantes = new ArrayList<>();

	public Actividad() {
	}

	// Constructor with all possible arguments
	public Actividad(int idActividad, int usuarioCreadorFk, int deporteFk, int instalacionFk, int minParticipantes,
			int maxParticipantes, @Size(max = 400) String comentarios, Date fechaActividad, Time horaActividad,
			Instalacion instalacion, Deporte deporte, Usuario creador) {
		this.idActividad = idActividad;
		this.usuarioCreadorFk = usuarioCreadorFk;
		this.deporteFk = deporteFk;
		this.instalacionFk = instalacionFk;
		this.minParticipantes = minParticipantes;
		this.maxParticipantes = maxParticipantes;
		this.comentarios = comentarios;
		this.fechaActividad = fechaActividad;
		this.horaActividad = horaActividad;
		this.instalacion = instalacion;
		this.deporte = deporte;
		this.creador = creador;
	}

	// Constructor with only mandatory arguments
	public Actividad(int idActividad, int usuarioCreadorFk, int deporteFk, int instalacionFk, Date fechaActividad,
			Time horaActividad) {
		this.idActividad = idActividad;
		this.usuarioCreadorFk = usuarioCreadorFk;
		this.deporteFk = deporteFk;
		this.instalacionFk = instalacionFk;
		this.fechaActividad = fechaActividad;
		this.horaActividad = horaActividad;
	}

	// Constructor with mandatory arguments + no.participants
	public Actividad(int idActividad, int usuarioCreadorFk, int deporteFk, int instalacionFk, int minParticipantes,
		int maxParticipantes, Date fechaActividad, Time horaActividad) {
			this.idActividad = idActividad;
			this.usuarioCreadorFk = usuarioCreadorFk;
			this.deporteFk = deporteFk;
			this.instalacionFk = instalacionFk;
			this.minParticipantes = minParticipantes;
			this.maxParticipantes = maxParticipantes;
			this.fechaActividad = fechaActividad;
			this.horaActividad = horaActividad;
		}
	

	public int getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	public int getUsuarioCreadorFk() {
		return usuarioCreadorFk;
	}

	public void setUsuarioCreadorFk(int usuarioCreadorFk) {
		this.usuarioCreadorFk = usuarioCreadorFk;
	}

	public int getDeporteFk() {
		return deporteFk;
	}

	public void setDeporteFk(int deporteFk) {
		this.deporteFk = deporteFk;
	}

	public int getInstalacionFk() {
		return instalacionFk;
	}

	public void setInstalacionFk(int instalacionFk) {
		this.instalacionFk = instalacionFk;
	}

	public int getMinParticipantes() {
		return minParticipantes;
	}

	public void setMinParticipantes(int minParticipantes) {
		this.minParticipantes = minParticipantes;
	}

	public int getMaxParticipantes() {
		return maxParticipantes;
	}

	public void setMaxParticipantes(int maxParticipantes) {
		this.maxParticipantes = maxParticipantes;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Date getFechaActividad() {
		return fechaActividad;
	}

	public void setFechaActividad(Date fechaActividad) {
		this.fechaActividad = fechaActividad;
	}

	public Time getHoraActividad() {
		return horaActividad;
	}

	public void setHoraActividad(Time horaActividad) {
		this.horaActividad = horaActividad;
	}

	public Instalacion getInstalacion() {
		return instalacion;
	}

	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	public List<Usuario> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Usuario> participantes) {
		this.participantes = participantes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idActividad;
		result = prime * result + usuarioCreadorFk;
		result = prime * result + deporteFk;
		result = prime * result + instalacionFk;
		result = prime * result + minParticipantes;
		result = prime * result + maxParticipantes;
		result = prime * result + ((comentarios == null) ? 0 : comentarios.hashCode());
		result = prime * result + ((fechaActividad == null) ? 0 : fechaActividad.hashCode());
		result = prime * result + ((horaActividad == null) ? 0 : horaActividad.hashCode());
		result = prime * result + ((instalacion == null) ? 0 : instalacion.hashCode());
		result = prime * result + ((deporte == null) ? 0 : deporte.hashCode());
		result = prime * result + ((creador == null) ? 0 : creador.hashCode());
		result = prime * result + ((participantes == null) ? 0 : participantes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actividad other = (Actividad) obj;
		if (idActividad != other.idActividad)
			return false;
		if (usuarioCreadorFk != other.usuarioCreadorFk)
			return false;
		if (deporteFk != other.deporteFk)
			return false;
		if (instalacionFk != other.instalacionFk)
			return false;
		if (minParticipantes != other.minParticipantes)
			return false;
		if (maxParticipantes != other.maxParticipantes)
			return false;
		if (comentarios == null) {
			if (other.comentarios != null)
				return false;
		} else if (!comentarios.equals(other.comentarios))
			return false;
		if (fechaActividad == null) {
			if (other.fechaActividad != null)
				return false;
		} else if (!fechaActividad.equals(other.fechaActividad))
			return false;
		if (horaActividad == null) {
			if (other.horaActividad != null)
				return false;
		} else if (!horaActividad.equals(other.horaActividad))
			return false;
		if (instalacion == null) {
			if (other.instalacion != null)
				return false;
		} else if (!instalacion.equals(other.instalacion))
			return false;
		if (deporte == null) {
			if (other.deporte != null)
				return false;
		} else if (!deporte.equals(other.deporte))
			return false;
		if (creador == null) {
			if (other.creador != null)
				return false;
		} else if (!creador.equals(other.creador))
			return false;
		if (participantes == null) {
			if (other.participantes != null)
				return false;
		} else if (!participantes.equals(other.participantes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Actividad [idActividad=" + idActividad + ", usuarioCreadorFk=" + usuarioCreadorFk + ", deporteFk="
				+ deporteFk + ", instalacionFk=" + instalacionFk + ", minParticipantes=" + minParticipantes
				+ ", maxParticipantes=" + maxParticipantes + ", comentarios=" + comentarios + ", fechaActividad="
				+ fechaActividad + ", horaActividad=" + horaActividad + ", instalacion=" + instalacion + ", deporte="
				+ deporte + ", creador=" + creador + ", participantes=" + participantes + "]";
	}

}
