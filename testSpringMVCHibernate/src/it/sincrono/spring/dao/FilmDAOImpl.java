package it.sincrono.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import it.sincrono.spring.model.Film;

@Repository
public class FilmDAOImpl implements FilmDAO {

	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Film> listFilms() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Film> filmList = session.createQuery("from Film where id<20 ").list();
		for(Film p : filmList){
			logger.info("\n \n Film List::"+p.getCosto());
		}
		return filmList;
	}

	@Override
	public List<Film> dammiFilmConTitolo(String titolo) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Film> filmList = session.createQuery("from Film where title ='"+titolo+"' ").list();
		for(Film p : filmList){
			logger.info("\n \n Film List::"+p.getCosto());
		}
		return filmList;
	}

	@Override
	public int dammiIdGrazieAlTitolo(String tit) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Film> filmList = session.createQuery("from Film where title ='"+tit+"' ").list();
		return filmList.get(0).getId();
	}
	
}
