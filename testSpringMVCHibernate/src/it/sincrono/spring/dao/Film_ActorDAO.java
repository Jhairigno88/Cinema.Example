package it.sincrono.spring.dao;

import java.util.List;

import it.sincrono.spring.model.Film_Actor;


public interface Film_ActorDAO {

	public List<Film_Actor> listFilmAttori();

	public List<Film_Actor> dammiListaAttoriDatoUnFilm(int idFilm);
}