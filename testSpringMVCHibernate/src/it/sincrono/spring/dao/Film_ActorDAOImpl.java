package it.sincrono.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import it.sincrono.spring.model.Film_Actor;

@Repository
public class Film_ActorDAOImpl implements Film_ActorDAO {

	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Film_Actor> listFilmAttori() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Film_Actor> film_Actor = session.createQuery("from Film_Actor").list();
		
		for(Film_Actor p : film_Actor){
			logger.info("\n \n Person List::"+p);
		}
		return film_Actor;
	}


	@Override
	public List<Film_Actor> dammiListaAttoriDatoUnFilm(int idFilm) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Film_Actor> film_Actor = session.createQuery("from Film_Actor where fk_id_film='"+idFilm+"' ").list();
		for(Film_Actor p : film_Actor){
			logger.info("\n \n Person List::"+p);
		}
		return film_Actor;
	}
	
}
