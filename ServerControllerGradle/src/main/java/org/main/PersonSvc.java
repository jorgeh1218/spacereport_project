package org.main;

import java.util.Collection;

import org.main.Person;
import org.main.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.common.collect.Lists;

@Controller
public class PersonSvc implements PersonSvcApi {
	
	@Autowired
	private PersonRepository people;	// Se crea el objeto que permite la interaccion con la BD

	@RequestMapping(value=PersonSvcApi.PERSON_SVC_PATH, method=RequestMethod.POST)
	public @ResponseBody boolean addPerson(@RequestBody Person p){
		if(people.findByCi(p.getCi()) != null)
			 return false;
		else			
			people.save(p);
		
		return true;
	}
	
	@RequestMapping(value=PersonSvcApi.PERSON_SVC_PATH, method=RequestMethod.GET)
	public @ResponseBody Collection<Person> getPersonList(){
		return Lists.newArrayList(people.findAll());
	}
	
	@RequestMapping(value=PersonSvcApi.PERSON_NAME_SEARCH_PATH, method=RequestMethod.GET)
	public @ResponseBody Collection<Person> findByName(
			@RequestParam(NAME_PARAMETER) String name
	){
		return people.findByName(name);
	}
	
	@RequestMapping(value=PersonSvcApi.PERSON_CI_SEARCH_PATH, method=RequestMethod.GET)
	public @ResponseBody Person findByCi(@RequestParam(CI_PARAMETER) String ci){
		 
		 return people.findByCi(ci);
	}
	
	@RequestMapping(value=PersonSvcApi.PERSON_DELETE_PATH, method=RequestMethod.GET)
	public @ResponseBody boolean deletePerson(@RequestParam(CI_PARAMETER) String ci){
		if(people.findByCi(ci) != null)
			people.delete(ci);
		else
			return false;
		
		return true;
	}

}
