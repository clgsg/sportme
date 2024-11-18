package com.clopez.sportme.models;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "CORREOS")
@NamedNativeQueries({
		@NamedNativeQuery(
			name = "Correos.getCorreoByIdUsuario",
			query = "select c.correo \r\n" + //
						"from CORREOS c\r\n" + //
						"where c.fk_usuario = :idUsuario;"),
		@NamedNativeQuery(
			name = "Correos.addCorreoUsuario", 
			query = "insert into CORREOS (fk_usuario, correo) values (:idUsuario, :correo); "),
		@NamedNativeQuery(
			name = "Correos.updateCorreoUsuario", 
			query = "update CORREOS\r\n" + //
								"set correo = :nuevoCorreo\r\n" + //
								"where fk_usuario=:idUsuario; ")
})
public class Correo implements Serializable {

	private static final long serialVersionUID = 4923736685549730810L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "idCorreo", sequenceName = "MAILIDSEQUENCE")
	private int idCorreo;

	@Column(name = "fk_usuario")
	private int idUsuario;

	@Column(name = "correo")
	private String correo;

	@OneToOne(cascade = CascadeType.PERSIST, mappedBy = "correo")
	private Usuario usuario;

	public Correo() {
	}

	public Correo(int idCorreo, int idUsuario, String correo, Usuario usuario) {
		this.idCorreo = idCorreo;
		this.idUsuario = idUsuario;
		this.correo = correo;
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdCorreo() {
		return idCorreo;
	}

	public void setIdCorreo(int idCorreo) {
		this.idCorreo = idCorreo;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCorreo;
		result = prime * result + idUsuario;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Correo other = (Correo) obj;
		if (idCorreo != other.idCorreo)
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Correo [idCorreo=" + idCorreo + ", idUsuario=" + idUsuario + ", correo=" + correo + ", usuario="
				+ usuario + "]";
	}

}
