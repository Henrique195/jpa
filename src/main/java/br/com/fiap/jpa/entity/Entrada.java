package br.com.fiap.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "t_gce_entrada")
@SequenceGenerator(name = "entrada", sequenceName = "sq_t_gce_entrada", allocationSize = 1)

public class Entrada implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6150297057346392526L;
	
	public Entrada() {
		
	}
	
	public Entrada(int numeroEntrada, String nomeEntrada, Evento evento) {
		this.numeroEntrada = numeroEntrada;
		this.nomeEntrada = nomeEntrada;
		this.evento = evento;
	}

	@Id
	@Column(name = "id_entrada")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entrada")
	private Long id;
	
	@Column(name = "nr_entrada", nullable = false)
	private int numeroEntrada;
	
	@Column(name = "nm_entrada", length= 20, nullable = false)
	private String nomeEntrada;
	
	
	@ManyToOne
	@JoinColumn(name= "id_evento")
	private Evento evento;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getNumeroEntrada() {
		return numeroEntrada;
	}


	public void setNumeroEntrada(int numeroEntrada) {
		this.numeroEntrada = numeroEntrada;
	}


	public String getNomeEntrada() {
		return nomeEntrada;
	}


	public void setNomeEntrada(String nomeEntrada) {
		this.nomeEntrada = nomeEntrada;
	}


	public Evento getEvento() {
		return evento;
	}


	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	@Override
	public String toString() {
		
		return "\nNumero: " + this.getNumeroEntrada()
			+ "\nNome: " + this.getNomeEntrada()
			+ "\nEvento " + this.getEvento().getDescricao();
			
		}
	

}
