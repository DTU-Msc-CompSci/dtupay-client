package dtu.example;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class TransactionService {

    WebTarget baseUrl ;
    public TransactionService() {
        Client client = ClientBuilder.newClient();
        baseUrl = client.target("http://localhost:8080/");
    }

    public Response initiateTransaction(String cid , String mid, int amount) {
        return baseUrl.path("transaction")
                .request()
                .post(Entity.entity(new Transaction(cid, mid, amount), MediaType.APPLICATION_JSON));
    }
}

