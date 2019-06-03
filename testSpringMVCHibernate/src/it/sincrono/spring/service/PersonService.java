package it.sincrono.spring.service;

import java.util.List;
import java.util.Map;

import it.sincrono.spring.model.Person;

public interface PersonService {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);
	public List<Person> cercaAttoreConIniziali(String lettereIniziali);
	public int quantiAttoriHannoQuesteIniziali(String lettereIniziali) ;
	public Map<String, Double> dammiCostoTotaleFilmAttore(String nome_attore);
}
