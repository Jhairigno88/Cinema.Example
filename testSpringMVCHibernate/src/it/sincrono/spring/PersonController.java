package it.sincrono.spring;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.sincrono.spring.model.Person;
import it.sincrono.spring.service.FilmService;
import it.sincrono.spring.service.Film_ActorService;
import it.sincrono.spring.service.PersonService;

@Controller
public class PersonController {
	
	private PersonService personService; //interfaccia
	
	@Autowired//(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}
	
	private FilmService filmService; //interfaccia
	@Autowired
	@Qualifier(value="filmService")
	public void setFilmService(FilmService fs){
		this.filmService = fs;
	}
	
	private Film_ActorService film_ActorService; //interfaccia
	@Autowired
	@Qualifier(value="film_ActorService")
	public void setFilm_ActorService(Film_ActorService fas){
		this.film_ActorService = fas;
	}
		
// fine autowired 	
	
	@RequestMapping(value = "/dammiCostoFilmAttore", method = RequestMethod.POST)
	public String dammiCostoFilmAttore(Model model , String nome_attore) {    	
		model.addAttribute("costoTotaleFilmAttore", this.personService.dammiCostoTotaleFilmAttore(nome_attore));
		return "dammiCostoFilmAttore";
	}
	
	@RequestMapping(value = "/dammiListaAttori", method = RequestMethod.POST)
	public String dammiAttori(Model model , String tit) {
    	model.addAttribute("titolo",tit);
		model.addAttribute("listaAttoriDiQuestoTitolo", this.film_ActorService.dammiListaAttoriDatoUnFilm(this.filmService.dammiIdGrazieAlTitolo(tit)));
		return "dammiGliAttoriDelTitolo";
	}
	
    @RequestMapping(value = "/filmjsp", method = RequestMethod.POST)
	public String filmjsp(Model model) {
    	//model.addAttribute("film", new Film());
		model.addAttribute("listFilms", this.filmService.listFilms());
		model.addAttribute("listFilmAttori", this.film_ActorService.listFilmAttori());
		return "film";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listPersons1(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}
	
	@RequestMapping(value = "/ajaxjsp", method = RequestMethod.GET)
	public String ajaxjsp(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "ajax";
	}
		
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		if(p.getId_act() == 0){
			//new person, add it
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}
		return "redirect:/persons";
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
        this.personService.removePerson(id);
        return "redirect:/persons";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
    
	@RequestMapping(value = "/inizialiNomeAttore", method = RequestMethod.POST)
	public String user(String iniziali, Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.cercaAttoreConIniziali(iniziali));
		return "person";
	}
	
	@RequestMapping(value = "demo2/{iniziali2}", method = RequestMethod.GET)
	@ResponseBody
	public String demo2(@PathVariable("iniziali2") String iniziali2) {
		
		return "gli attori con queste iniziali sono : " + this.personService.quantiAttoriHannoQuesteIniziali(iniziali2) ;
	}
	
	@RequestMapping(value = "cambia/{parola}", method = RequestMethod.GET)
	@ResponseBody
	public String cambiaParola(@PathVariable("parola") String parola) {
		
		return parola;
	}
	
	@RequestMapping(value = "riempiSelect", method = RequestMethod.POST)
	@ResponseBody
	public void riempiSelect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String scelta = request.getParameter("scelta");
		List<Person> listaPersone = new ArrayList<Person>();
		PrintWriter out = response.getWriter();
		JsonArrayBuilder builder = Json.createArrayBuilder();
		
		if(scelta.equals("persone"))
		{
			listaPersone = this.personService.listPersons();
			
			for(int i = 0; i < listaPersone.size(); i++)
				builder.add(listaPersone.get(i).getName());
		
			JsonArray obj = builder.build();			
			out.print(obj);
		}
		else
		{
			out.print("vuoto");
		}
	}
	
	@RequestMapping(value = "creaTabella", method = RequestMethod.POST)
	@ResponseBody
	public void creaTabella(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<Person> listaPersone = new ArrayList<Person>();
		PrintWriter out = response.getWriter();
		JsonArrayBuilder builder = Json.createArrayBuilder();
		
		listaPersone = this.personService.listPersons();
			
		for(int i = 0; i < listaPersone.size(); i++)			
			builder.add(Json.createObjectBuilder().add("id_persona", listaPersone.get(i).getId_act())
					.add("nome_persona", listaPersone.get(i).getName()));
		
			JsonArray obj = builder.build();			
			out.print(obj);
		}

}

