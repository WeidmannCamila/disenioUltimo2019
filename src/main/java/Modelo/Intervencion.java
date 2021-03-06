package Modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INTERVENCION")
public class Intervencion implements Serializable {
	
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_INTERVENCION")
	private Integer id_intervencion;
	
	
	@Column(name = "FECHA_INICIO", nullable= false)
	private Date fecha_inicio;
	
	@Column(name = "FECHA_FIN", nullable= false)
	private Date fecha_fin;
	
	@Column(name = "OBSERVACIONES", length = 5000)
	private String observaciones;
	
	
	@ManyToOne
	@JoinColumn(name = "id_grupo")
	private GrupoResolucion gruporesolucion;
	
	@ManyToOne
	@JoinColumn(name = "num_ticket")
	private Ticket ticket;
	
	
	@JoinColumn(name = "id_estadointerv")
	@Enumerated(value = EnumType.STRING) /*VER*/
	private EstadoIntervencion estadointervencion; /*clase enumeration VEEER */
	
	
	public Intervencion () {
		
	}
	
	public Intervencion(Integer id_intervencion, Date fecha_inicio, Date fecha_fin, String observaciones,
			GrupoResolucion gruporesolucion, Ticket ticket, EstadoIntervencion estadointervencion) {
		
		this.id_intervencion = id_intervencion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.observaciones = observaciones;
		this.gruporesolucion = gruporesolucion;
		this.ticket = ticket;
		this.estadointervencion = estadointervencion;
	}

	public Integer getId_intervencion() {
		return id_intervencion;
	}

	public void setId_intervencion(Integer id_intervencion) {
		this.id_intervencion = id_intervencion;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public GrupoResolucion getGruporesolucion() {
		return gruporesolucion;
	}

	public void setGruporesolucion(GrupoResolucion gruporesolucion) {
		this.gruporesolucion = gruporesolucion;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public EstadoIntervencion getEstadointervencion() {
		return estadointervencion;
	}

	public void setEstadointervencion(EstadoIntervencion estadointervencion) {
		this.estadointervencion = estadointervencion;
	}

	@Override
	public String toString() {
		return "Intervencion [id_intervencion=" + id_intervencion + ", fecha_inicio=" + fecha_inicio + ", fecha_fin="
				+ fecha_fin + ", observaciones=" + observaciones + ", gruporesolucion=" + gruporesolucion + ", ticket="
				+ ticket + ", estadointervencion=" + estadointervencion + "]";
	}


	


}

