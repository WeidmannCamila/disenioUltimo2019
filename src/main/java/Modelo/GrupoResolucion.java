package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GRUPORESOLUCION")
public class GrupoResolucion implements  Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_GRUPO")
	private Integer id_grupo;
	
	@Column(name = "NOM_GRUPO", length = 150, nullable= false)
	private String nom_grupo;


	@Column(name = "NIVEL")
	private Integer nivel;

	@OneToMany(mappedBy = "gruporesolucion")
	private List<Usuario> listausuario = new ArrayList<>(); 
	
	@OneToMany(mappedBy = "gruporesolucion")
	private List<Intervencion> listaintervenciones = new ArrayList<>();
	
	
	@ManyToMany
	@JoinTable(name="grupo_clasificacion", 
				joinColumns = {@JoinColumn (name="id_grupo")}, 
				inverseJoinColumns={@JoinColumn(name="codigo")})
	private List<Clasificacion> listaclasificacion = new ArrayList<>();
	
	public GrupoResolucion() {
		
	}
	
	public GrupoResolucion(Integer id_grupo, String nom_grupo, Integer nivel, List<Usuario> listausuario,
			List<Intervencion> listaintervenciones) {
		
		this.id_grupo = id_grupo;
		this.nom_grupo = nom_grupo;
		this.nivel = nivel;
		this.listausuario = listausuario;
		this.listaintervenciones = listaintervenciones;
	}

	public Integer getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(Integer id_grupo) {
		this.id_grupo = id_grupo;
	}

	public String getNom_grupo() {
		return nom_grupo;
	}

	public void setNom_grupo(String nom_grupo) {
		this.nom_grupo = nom_grupo;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public List<Usuario> getListausuario() {
		return listausuario;
	}

	public void setListausuario(List<Usuario> listausuario) {
		this.listausuario = listausuario;
	}

	public List<Intervencion> getListaintervenciones() {
		return listaintervenciones;
	}

	public void setListaintervenciones(List<Intervencion> listaintervenciones) {
		this.listaintervenciones = listaintervenciones;
	}

	@Override
	public String toString() {
		return "GrupoResolucion [id_grupo=" + id_grupo + ", nom_grupo=" + nom_grupo + ", nivel=" + nivel
				+ ", listausuario=" + listausuario + ", listaintervenciones=" + listaintervenciones + "]";
	}

	
	
}

