package org.main;

import java.util.Collection;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import org.main.Person;

// Interface para cliente-servidor

public interface PersonSvcApi {

	public static final String NAME_PARAMETER = "name";
	public static final String AGE_PARAMETER = "age";
	public static final String CI_PARAMETER = "ci";
	public static final String PERSON_SVC_PATH = "/person";
	public static final String PERSON_NAME_SEARCH_PATH = PERSON_SVC_PATH + "/findByName";
	public static final String PERSON_CI_SEARCH_PATH = PERSON_SVC_PATH + "/findByCi";
	public static final String PERSON_DELETE_PATH = PERSON_SVC_PATH + "/delete";
	
	@GET(PERSON_SVC_PATH)
	public Collection<Person> getPersonList();
	
	@POST(PERSON_SVC_PATH)
	public boolean addPerson(@Body Person p);
	
	@GET(PERSON_NAME_SEARCH_PATH)
	public Collection<Person> findByName(@Query(NAME_PARAMETER) String person);
	
	@GET(PERSON_NAME_SEARCH_PATH)
	public Person findByCi(@Query(NAME_PARAMETER) String ci);
	
	@GET(PERSON_DELETE_PATH)
	public boolean deletePerson(@Query(CI_PARAMETER) String ci);

}
