package dtu.example;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class PersonService {
	
	WebTarget baseUrl;
	public PersonService() {
		Client client = ClientBuilder.newClient();
		baseUrl = client.target("http://localhost:8080/");
	}
	
	public Person getPerson() {
		return baseUrl.path("person")
				.request()
				.accept(MediaType.APPLICATION_JSON)
				.get(Person.class);
	}
	
	public void setPerson(Person person) {
		baseUrl.path("person")
		.request()
		.put(Entity.entity(person, MediaType.APPLICATION_JSON));
	}
}
