import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class CustomerAPI {

    WebTarget baseUrl;

    public CustomerAPI() {
        Client client = ClientBuilder.newClient();
        baseUrl = client.target("http://localhost:8080/");
    }

    public Response registerCustomer(String cpr, String first, String last, String bankId) {
        // User down here is going to be our domain User (First/Last name, CPR Number, BankId)
        User user = new User();
        user.setCprNumber(cpr);
        user.setFirstName(first);
        user.setLastName(last);
        user.setBankId(bankId);
        Response response = baseUrl.path("customer")
                .request()
                .post(Entity.entity(user,MediaType.APPLICATION_JSON));

        return response;
    }

}
