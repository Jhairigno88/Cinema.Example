package it.sincrono.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.sincrono.spring.dao.FilmDAO;
import it.sincrono.spring.model.Film;

@Service
public class FilmServiceImpl  implements FilmService {
		
		private FilmDAO filmDAO;

		public void setFilmDAO(FilmDAO filmDAO) {
			this.filmDAO = filmDAO;
		}
		
		@Override
		@Transactional
		public List<Film> listFilms() {
			return this.filmDAO.listFilms();
		}

		@Override
		@Transactional
		public int dammiIdGrazieAlTitolo(String tit) {
			return this.filmDAO.dammiIdGrazieAlTitolo(tit);
		}
	
}
