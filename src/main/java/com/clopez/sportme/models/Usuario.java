package com.clopez.sportme.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    private static final long serialVersionUID = -6567297177530353288L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "idUsuario", sequenceName = "USEIRIDSEQUENCE")
    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "apodo")
    private String apodo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido1")
    private String primerApellido;

    @Column(name = "apellido1")
    private String segundoApellido;

    @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name="id_correo", referencedColumnName = "id_usuario")
    private Correo correo;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "creador")
    private List<Actividad> actividadesCreadas = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "participantes")
    private List<Actividad> actividadesParticipante = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(int idUsuario, String apodo, String nombre, String primerApellido, String segundoApellido,
            Correo correo) {
        this.idUsuario = idUsuario;
        this.apodo = apodo;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correo = correo;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Correo getCorreo() {
        return correo;
    }

    public void setCorreo(Correo correo) {
        this.correo = correo;
    }

    public List<Actividad> getActividadesCreadas() {
        return actividadesCreadas;
    }

    public void addActividadCreada(Actividad actividad){
        this.actividadesCreadas.add(actividad);
    }

    public List<Actividad> getActividadesParticipante() {
        return actividadesParticipante;
    }

    public void addActividadParticipante(Actividad actividadParticipante) {
        this.actividadesParticipante.add(actividadParticipante);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idUsuario;
        result = prime * result + ((apodo == null) ? 0 : apodo.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((primerApellido == null) ? 0 : primerApellido.hashCode());
        result = prime * result + ((segundoApellido == null) ? 0 : segundoApellido.hashCode());
        result = prime * result + ((correo == null) ? 0 : correo.hashCode());
        result = prime * result + ((actividadesCreadas == null) ? 0 : actividadesCreadas.hashCode());
        result = prime * result + ((actividadesParticipante == null) ? 0 : actividadesParticipante.hashCode());
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
        Usuario other = (Usuario) obj;
        if (idUsuario != other.idUsuario)
            return false;
        if (apodo == null) {
            if (other.apodo != null)
                return false;
        } else if (!apodo.equals(other.apodo))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (primerApellido == null) {
            if (other.primerApellido != null)
                return false;
        } else if (!primerApellido.equals(other.primerApellido))
            return false;
        if (segundoApellido == null) {
            if (other.segundoApellido != null)
                return false;
        } else if (!segundoApellido.equals(other.segundoApellido))
            return false;
        if (correo == null) {
            if (other.correo != null)
                return false;
        } else if (!correo.equals(other.correo))
            return false;
        if (actividadesCreadas == null) {
            if (other.actividadesCreadas != null)
                return false;
        } else if (!actividadesCreadas.equals(other.actividadesCreadas))
            return false;
        if (actividadesParticipante == null) {
            if (other.actividadesParticipante != null)
                return false;
        } else if (!actividadesParticipante.equals(other.actividadesParticipante))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", apodo=" + apodo + ", nombre=" + nombre + ", primerApellido="
                + primerApellido + ", segundoApellido=" + segundoApellido + ", correo=" + correo + ", actividadesCreadas="
                + actividadesCreadas + ", actividadesParticipante=" + actividadesParticipante + "]";
    }

}