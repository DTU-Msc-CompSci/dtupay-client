package dtu.example;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*
	Replace the class with your own step definition
   	classes.
 */
public class ExampleSteps {
	
	Counter counter = new Counter();

	@Given("the initial value of the counter as {int}")
	public void theInitialValueOfTheCounterAs(Integer int1) {
		counter.setCounter(int1);
	}

	@When("the counter is incremented")
	public void theCounterIsIncremented() {
		counter.inc();
	}

	@Then("the final value of the counter is {int}")
	public void theFinalValueOfTheCounterIs(Integer int1) {
		assertEquals((int)int1, counter.getCounter());
	}
}

