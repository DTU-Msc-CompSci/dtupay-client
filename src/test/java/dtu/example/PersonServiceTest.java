package dtu.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonServiceTest {
	
	Person person;
	PersonService service = new PersonService();
	
	
	@When("I call the hello service to get person")
	public void iCallTheHelloServiceToGetPerson() {
	    person = service.getPerson();
	}

	@Then("I get a person with name {string} and address {string}")
	public void iGetAPersonWithNameAndAddress(String name, String address) {
	    assertEquals(name, person.getName());
	    assertEquals(address, person.getAddress());
	}
	
	@When("I upate the person with name {string} and address {string}")
	public void iUpateThePersonWithNameAndAddress(String name, String address) {
	    service.setPerson(new Person(name,address));
	}
}
