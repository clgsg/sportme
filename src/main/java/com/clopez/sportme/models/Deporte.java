package com.clopez.sportme.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPORTES")
@NamedNativeQueries({
		@NamedNativeQuery(
			name = "Deportes.getAllDeportes", 
			query = "select d.deporte from DEPORTES d;"),
		@NamedNativeQuery(
			name = "Deportes.getDeporteById", 
			query = "select d.deporte from DEPORTES d;")
})
public class Deporte implements Serializable {
	private static final long serialVersionUID = -6567297175530353289L;

	@Id
	private int idDeporte;

	@Column(name = "deporte")
	private String deporte;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "deporte")
	private List<Actividad> actividades = new ArrayList<>();

	public Deporte() {
	}

	public Deporte(int idDeporte, String deporte) {
		this.idDeporte = idDeporte;
		this.deporte = deporte;
	}

	public int getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(int idDeporte) {
		this.idDeporte = idDeporte;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public List<Actividad> getActividades() {
		return actividades;
	}

	public void addActividad(Actividad actividad) {
		this.actividades.add(actividad);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDeporte;
		result = prime * result + ((deporte == null) ? 0 : deporte.hashCode());
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
		Deporte other = (Deporte) obj;
		if (idDeporte != other.idDeporte)
			return false;
		if (deporte == null) {
			if (other.deporte != null)
				return false;
		} else if (!deporte.equals(other.deporte))
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
		return "Deporte [idDeporte=" + idDeporte + ", deporte=" + deporte + ", actividades=" + actividades + "]";
	}

}
