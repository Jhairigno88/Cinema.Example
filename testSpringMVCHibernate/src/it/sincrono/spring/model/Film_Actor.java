package it.sincrono.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="film_actor")
public class Film_Actor implements java.io.Serializable{	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_film_actor", unique = true, nullable = false)
	private Integer id_film_actor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_id_film")
	   private Film film;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_id_actor")
	private Person actor;
	
	public Integer getId_film_actor() {
		return id_film_actor;
	}

	public void setId_film_actor(Integer id_film_actor) {
		this.id_film_actor = id_film_actor;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Person getActor() {
		return actor;
	}

	public void setActor(Person actor) {
		this.actor = actor;
	}
	
}