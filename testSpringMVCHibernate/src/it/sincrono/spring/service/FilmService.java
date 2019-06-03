package it.sincrono.spring.service;

import java.util.List;

import it.sincrono.spring.model.Film;

public interface FilmService {

	public List<Film> listFilms();

	public int dammiIdGrazieAlTitolo(String tit);

}
