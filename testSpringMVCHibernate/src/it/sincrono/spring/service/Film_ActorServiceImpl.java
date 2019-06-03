package it.sincrono.spring.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.sincrono.spring.dao.Film_ActorDAO;
import it.sincrono.spring.model.Film_Actor;

public class Film_ActorServiceImpl implements Film_ActorService {

	private Film_ActorDAO film_ActorDAO ;
	public void setFilm_ActorDAO (Film_ActorDAO  film_ActorDAO ) {
		this.film_ActorDAO = film_ActorDAO;
	}
	
	@Override
	@Transactional
	public List<Film_Actor> listFilmAttori() {
		return this.film_ActorDAO.listFilmAttori();
	}

	@Override
	@Transactional
	public List<Film_Actor> dammiListaAttoriDatoUnFilm(int idFilm) {
		return this.film_ActorDAO.dammiListaAttoriDatoUnFilm(idFilm);
	}

}
