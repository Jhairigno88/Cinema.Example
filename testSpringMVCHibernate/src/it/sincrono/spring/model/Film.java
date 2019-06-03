package it.sincrono.spring.model;


import java.util.HashSet;
import java.util.Set;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="film")
public class Film implements java.io.Serializable{
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_film", unique = true, nullable = false)
	private Integer id;
	 
	@Column(name="title")
	private String titolo;
	
	@Column(name="costo")
	private Double costo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "film")
	public Set<Film_Actor> film_film_Actor = new HashSet<Film_Actor>(0);
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Set<Film_Actor> getFilm_film_Actor() {
		return film_film_Actor;
	}

	public void setFilm_film_Actor(Set<Film_Actor> film_film_Actor) {
		this.film_film_Actor = film_film_Actor;
	}

}
