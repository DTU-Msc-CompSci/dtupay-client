package dtu.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.ws.rs.core.Response;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class PaymentSteps {
    String customer;
    String merchant;
    TransactionService transactionService = new TransactionService();
    Response response;
    @Given("a customer with id {string}")
    public void a_customer_with_id(String id) {
        customer = id;
    }

    @Given("a merchant with id {string}")
    public void a_merchant_with_id(String id) {
        merchant = id;
    }

    @When("the merchant initiates a payment for {int} kr by the customer")
    public void the_merchant_initiates_a_payment_for_kr_by_the_customer(Integer int1) {
        response = transactionService.initiateTransaction(customer,merchant,int1);
    }

    //ASK Hubert seperating domain from tech ??
    @Then("the payment is successful")
    public void the_payment_is_successful() {
        assertEquals(201,response.getStatus());
    }

}
