package com.clopez.sportme.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "TIPOS_INSTALACION")
@NamedNativeQuery(
	name="TIPOS_INSTALACION.getTipoInstalacion",
	query = "select tipo from TIPOS_INSTALACION where id_tipo=:idTipoInstalacion;")
public class TipoInstalacion implements Serializable {

	private static final long serialVersionUID = -4229732694376342854L;

	@Id
	@Column(name = "id_tipo")
	private int idTipo;

	@Column(name = "tipo")
	private Instalacion tipoInstalacion;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoInstalacion")
	private Instalacion instalacion;

	public TipoInstalacion() {
	}

	public TipoInstalacion(int idTipo, Instalacion tipoInstalacion, Instalacion instalacion) {
		this.idTipo = idTipo;
		this.tipoInstalacion = tipoInstalacion;
		this.instalacion = instalacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public Instalacion getTipoInstalacion() {
		return tipoInstalacion;
	}

	public void setTipoInstalacion(Instalacion tipoInstalacion) {
		this.tipoInstalacion = tipoInstalacion;
	}

	public Instalacion getInstalacion() {
		return instalacion;
	}

	public void setInstalacion(Instalacion instalacion) {
		this.instalacion = instalacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipo;
		result = prime * result + ((tipoInstalacion == null) ? 0 : tipoInstalacion.hashCode());
		result = prime * result + ((instalacion == null) ? 0 : instalacion.hashCode());
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
		TipoInstalacion other = (TipoInstalacion) obj;
		if (idTipo != other.idTipo)
			return false;
		if (tipoInstalacion == null) {
			if (other.tipoInstalacion != null)
				return false;
		} else if (!tipoInstalacion.equals(other.tipoInstalacion))
			return false;
		if (instalacion == null) {
			if (other.instalacion != null)
				return false;
		} else if (!instalacion.equals(other.instalacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoInstalacion [idTipo=" + idTipo + ", tipoInstalacion=" + tipoInstalacion + ", instalacion="
				+ instalacion + "]";
	}

}
