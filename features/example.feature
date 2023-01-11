Feature: hello service

	Scenario: hello service retuns correct answer
		When I call the hello service
		Then I get the answer "Hello RESTEasy"

	Scenario: hello service getPerson returns correct answer
		When I call the hello service to get person
		Then I get a person with name "Mathias" and address "Lyngby"
		
		
	Scenario: Updating the person
		When I upate the person with name "Kyle" and address "Los Angeles"
		And I call the hello service to get person
		Then I get a person with name "Kyle" and address "Los Angeles"
		
		
		