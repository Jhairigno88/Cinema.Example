package it.sincrono.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.sincrono.spring.dao.PersonDAO;
import it.sincrono.spring.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonDAO personDAO;

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	@Override
	@Transactional
	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}

	@Override
	@Transactional
	public void addPerson(Person p) {
		this.personDAO.addPerson(p);
	}

	@Override
	@Transactional
	public void updatePerson(Person p) {
		this.personDAO.updatePerson(p);
	}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		return this.personDAO.getPersonById(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		this.personDAO.removePerson(id);
	}

	@Override
	@Transactional
	public List<Person> cercaAttoreConIniziali(String lettereIniziali) {
		return this.personDAO.cercaAttoreConIniziali(lettereIniziali);
	}

	@Override
	@Transactional
	public int quantiAttoriHannoQuesteIniziali(String lettereIniziali) {
		return this.personDAO.quantiAttoriHannoQuesteIniziali(lettereIniziali);
	}

	@Override
	@Transactional
	public Map<String, Double> dammiCostoTotaleFilmAttore(String nome_attore) {
		return this.personDAO.dammiCostoTotaleFilmAttore(nome_attore);
	}

}
