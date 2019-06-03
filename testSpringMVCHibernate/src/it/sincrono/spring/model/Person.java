package it.sincrono.spring.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="actor")
public class Person implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_actor", unique = true, nullable = false)
	private Integer id_act = 0;
	
	@Column(name="first_name")
	private String name;
	
	@Column(name="last_name")
	private String lastName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "actor")
	public Set<Film_Actor> actor_film_Actor = new HashSet<Film_Actor>(0);

	public Integer getId_act() {
		return id_act;
	}

	public void setId_act(Integer id_act) {
		this.id_act = id_act;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Film_Actor> getActor_film_Actor() {
		return actor_film_Actor;
	}

	public void setActor_film_Actor(Set<Film_Actor> actor_film_Actor) {
		this.actor_film_Actor = actor_film_Actor;
	}

	@Override
	public String toString(){
		return "id="+id_act+", name="+name+", lastName="+lastName;
	}
}
