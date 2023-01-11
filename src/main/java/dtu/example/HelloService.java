package dtu.example;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;

public class HelloService {

	public String hello() {
		Client c = ClientBuilder.newClient();
		WebTarget r = c.target("http://localhost:8080/");
		
		String result = r.path("hello")
				.request()
				.get(String.class);
		return result;
	}

}
