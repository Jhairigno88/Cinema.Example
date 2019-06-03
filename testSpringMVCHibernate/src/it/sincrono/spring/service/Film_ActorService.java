package it.sincrono.spring.service;

import java.util.List;

import it.sincrono.spring.model.Film_Actor;

public interface Film_ActorService {

		public List<Film_Actor> listFilmAttori();

		public List<Film_Actor> dammiListaAttoriDatoUnFilm(int idFilm);

}
