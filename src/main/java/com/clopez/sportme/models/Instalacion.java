package com.clopez.sportme.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "instalaciones")
public class Instalacion implements Serializable {

	private static final long serialVersionUID = -8806477198938244169L;

	@Id
	private int idInstalacion;

	private String tipoVia;
	private String nombreVia;
	private String numVia;

	@Column(name = "fk_tipo_instalacion")
	private int idTipo;

	private String alumbrado;
	private String nombreInstalacion;

	@ManyToOne
	@JoinColumn(name = "id_tipo")
	private TipoInstalacion tipoInstalacion;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "instalacion")
	private List<Actividad> actividades = new ArrayList<>();

	public Instalacion() {
	}

	public Instalacion(int idInstalacion, String tipoVia, String nombreVia, String numVia, int idTipo, String alumbrado,
			String nombreInstalacion, TipoInstalacion tipoInstalacion) {
		this.idInstalacion = idInstalacion;
		this.tipoVia = tipoVia;
		this.nombreVia = nombreVia;
		this.numVia = numVia;
		this.idTipo = idTipo;
		this.alumbrado = alumbrado;
		this.nombreInstalacion = nombreInstalacion;
		this.tipoInstalacion = tipoInstalacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdInstalacion() {
		return idInstalacion;
	}

	public void setIdInstalacion(int idInstalacion) {
		this.idInstalacion = idInstalacion;
	}

	public String getTipoVia() {
		return tipoVia;
	}

	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}

	public String getNombreVia() {
		return nombreVia;
	}

	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}

	public String getNumVia() {
		return numVia;
	}

	public void setNumVia(String numVia) {
		this.numVia = numVia;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getAlumbrado() {
		return alumbrado;
	}

	public void setAlumbrado(String alumbrado) {
		this.alumbrado = alumbrado;
	}

	public String getNombreInstalacion() {
		return nombreInstalacion;
	}

	public void setNombreInstalacion(String nombreInstalacion) {
		this.nombreInstalacion = nombreInstalacion;
	}

	public TipoInstalacion getTipoInstalacion() {
		return tipoInstalacion;
	}

	public void setTipoInstalacion(TipoInstalacion tipoInstalacion) {
		this.tipoInstalacion = tipoInstalacion;
	}

	public List<Actividad> getActividades(){
		return actividades;
	}

	public void addActividad(Actividad actividad){
		this.actividades.add(actividad);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idInstalacion;
		result = prime * result + ((tipoVia == null) ? 0 : tipoVia.hashCode());
		result = prime * result + ((nombreVia == null) ? 0 : nombreVia.hashCode());
		result = prime * result + ((numVia == null) ? 0 : numVia.hashCode());
		result = prime * result + idTipo;
		result = prime * result + ((alumbrado == null) ? 0 : alumbrado.hashCode());
		result = prime * result + ((nombreInstalacion == null) ? 0 : nombreInstalacion.hashCode());
		result = prime * result + ((tipoInstalacion == null) ? 0 : tipoInstalacion.hashCode());
		result = prime * result + ((actividades == null) ? 0 : actividades.hashCode());
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
		Instalacion other = (Instalacion) obj;
		if (idInstalacion != other.idInstalacion)
			return false;
		if (tipoVia == null) {
			if (other.tipoVia != null)
				return false;
		} else if (!tipoVia.equals(other.tipoVia))
			return false;
		if (nombreVia == null) {
			if (other.nombreVia != null)
				return false;
		} else if (!nombreVia.equals(other.nombreVia))
			return false;
		if (numVia == null) {
			if (other.numVia != null)
				return false;
		} else if (!numVia.equals(other.numVia))
			return false;
		if (idTipo != other.idTipo)
			return false;
		if (alumbrado == null) {
			if (other.alumbrado != null)
				return false;
		} else if (!alumbrado.equals(other.alumbrado))
			return false;
		if (nombreInstalacion == null) {
			if (other.nombreInstalacion != null)
				return false;
		} else if (!nombreInstalacion.equals(other.nombreInstalacion))
			return false;
		if (tipoInstalacion == null) {
			if (other.tipoInstalacion != null)
				return false;
		} else if (!tipoInstalacion.equals(other.tipoInstalacion))
			return false;
		if (actividades == null) {
			if (other.actividades != null)
				return false;
		} else if (!actividades.equals(other.actividades))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Instalacion [idInstalacion=" + idInstalacion + ", tipoVia=" + tipoVia + ", nombreVia=" + nombreVia
				+ ", numVia=" + numVia + ", idTipo=" + idTipo + ", alumbrado=" + alumbrado + ", nombreInstalacion="
				+ nombreInstalacion + ", tipoInstalacion=" + tipoInstalacion + ", actividades=" + actividades + "]";
	}

}
