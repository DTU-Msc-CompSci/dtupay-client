import dtu.ws.fastmoney.BankService;
import dtu.ws.fastmoney.BankServiceException_Exception;
import dtu.ws.fastmoney.BankServiceService;
import dtu.ws.fastmoney.User;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;

public class TransactionSteps {

    BankService bankService = new BankServiceService().getBankServicePort();
    User customer = new User();
    User merchant = new User();
    String customerBankId;
    String merchantBankId;
    @Before
    public void init() {
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setCprNumber("123456-7890");

        merchant.setFirstName("Jane");
        merchant.setLastName("Doe");
        merchant.setCprNumber("123456-7891");
        try {
            customerBankId = bankService.createAccountWithBalance(customer, BigDecimal.valueOf(1000));
            merchantBankId = bankService.createAccountWithBalance(merchant, BigDecimal.valueOf(2000));

        } catch (BankServiceException_Exception e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() {
    try {
        bankService.retireAccount(customerBankId);
        bankService.retireAccount(merchantBankId);
    } catch (BankServiceException_Exception e) {
        throw new RuntimeException(e);
    }
}
    @Given("a customer registered with DTU Pay with balance {int}")
    public void aCustomerRegisteredWithDTUPayWithBalance(int arg0) {
        // User in DTU Pay
    }

    @And("a token that is associated with the customer")
    public void aTokenThatIsAssociatedWithTheCustomer() {

        // getToken()
    }

    @Given("a merchant registered with DTU Pay with balance {int}")
    public void aMerchantRegisteredWithDTUPayWithBalance(int arg0) {

        // User in DTU Pay
        // User has a bank (Before)
    }

    @When("the merchant requests a transaction for {int} kr by the customer")
    public void theMerchantRequestsATransactionForKrByTheCustomer(int arg0) {

        // Initiate the payment (Send to DTU Pay)
        // DTU Pay -> Bank
    }

    @Then("the transaction is successful")
    public void theTransactionIsSuccessful() {

        // Check response
    }

    @And("the balance of the customer at the bank is {int} kr")
    public void theBalanceOfTheCustomerAtTheBankIsKr(int arg0) {

        // Check directly with Bank
    }

    @And("the balance of the merchant at the bank is {int} kr")
    public void theBalanceOfTheMerchantAtTheBankIsKr(int arg0) {

        //Check directly with Bank
    }
}
