//import dtu.ws.fastmoney.BankService;
//import dtu.ws.fastmoney.BankServiceException_Exception;
//import dtu.ws.fastmoney.BankServiceService;
//import dtu.ws.fastmoney.User;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import jakarta.ws.rs.core.Response;
//
//import java.math.BigDecimal;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//public class PaymentStepsCopy {
//    String customer;
//    String merchant;
//    TransactionService transactionService = new TransactionService();
//    BankService bankService = new BankServiceService().getBankServicePort();
//    User customerBankAccount = new User();
//    User merchantBankAccount = new User();
//    String customerBankId;
//    String merchantBankId;
//    Response response;
//
//    @Before
//    public void setUp() {
//        customerBankAccount.setFirstName("John");
//        customerBankAccount.setLastName("Doe");
//        customerBankAccount.setCprNumber("123456-7890");
//
//        merchantBankAccount.setFirstName("Jane");
//        merchantBankAccount.setLastName("Doe");
//        merchantBankAccount.setCprNumber("123456-7891");
//        try {
//            customerBankId = bankService.createAccountWithBalance(customerBankAccount, BigDecimal.valueOf(1000));
//            merchantBankId = bankService.createAccountWithBalance(merchantBankAccount, BigDecimal.valueOf(2000));
//
//        } catch (BankServiceException_Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @After
//    public void tearDown() {
//        try {
//            bankService.retireAccount(customerBankId);
//            bankService.retireAccount(merchantBankId);
//        } catch (BankServiceException_Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Given("a customer with id {string}")
//    public void a_customer_with_id(String id) {
//        customer = id;
//    }
//
//    @Given("a merchant with id {string}")
//    public void a_merchant_with_id(String id) {
//        merchant = id;
//    }
//
//    @When("the merchant initiates a payment for {int} kr by the customer")
//    public void the_merchant_initiates_a_payment_for_kr_by_the_customer(Integer int1) {
//        response = transactionService.initiateTransaction(customerBankId,merchantBankId,int1);
//    }
//
//    //ASK Hubert seperating domain from tech ??
//    @Then("the payment is successful")
//    public void the_payment_is_successful() {
//        assertEquals(201,response.getStatus());
//    }
//
//    @Given("a customer with a bank account with balance {int}")
//    public void aCustomerWithABankAccountWithBalance(int arg0) {
//        // TODO: Make this more robust since it just references the Before/After blocks
//        assertNotNull(customerBankId);
//    }
//
//    @And("that the customer is registered with DTU Pay")
//    public void thatTheCustomerIsRegisteredWithDTUPay() {
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Given("a merchant with a bank account with balance {int}")
//    public void aMerchantWithABankAccountWithBalance(int arg0) {
//        // TODO: Make this more robust since it just references the Before/After blocks
//        assertNotNull(merchantBankId);
//    }
//
//
//    @Then("the balance of the customer at the bank is {int} kr")
//    public void the_balance_of_the_customer_at_the_bank_is_kr(Integer int1) throws BankServiceException_Exception {
//        Integer customerBalance =  Integer.valueOf(bankService.getAccount(customerBankId).getBalance().intValue());
//        assertEquals(int1, customerBalance);
//    }
//    @Then("the balance of the merchant at the bank is {int} kr")
//    public void the_balance_of_the_merchant_at_the_bank_is_kr(Integer int1) throws BankServiceException_Exception {
//        Integer customerBalance =  Integer.valueOf(bankService.getAccount(merchantBankId).getBalance().intValue());
//        assertEquals(int1, customerBalance);
//    }
//}
