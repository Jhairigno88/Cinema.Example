package it.sincrono.spring.dao;

import java.util.List;

import it.sincrono.spring.model.Film;

public interface FilmDAO {
	public List<Film> listFilms();
	public List<Film> dammiFilmConTitolo(String titolo);
	public int dammiIdGrazieAlTitolo(String tit);
}
