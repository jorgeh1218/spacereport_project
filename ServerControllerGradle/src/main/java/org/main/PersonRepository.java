package org.main;

import java.util.Collection;

import org.main.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Esta inteface ofrece la interaccion entre los objetos y la BD

@Repository
public interface PersonRepository extends CrudRepository<Person, String>{

	public Collection<Person> findByName(String name);
	public Person findByCi(String string);
}