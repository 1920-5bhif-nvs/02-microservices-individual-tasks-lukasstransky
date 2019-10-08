package at.htl.shop;

import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.annotation.RegistryType;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Model
public class CoffeeRequest {

    private Client client;
    private WebTarget tut;

    @PostConstruct
    public void initClient(){
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8080/coffee/api/coffees");
    }

    public JsonObject fetchCoffee(){
        Response response = this.tut.request().get();
        int status = response.getStatus();
        return response.readEntity(JsonObject.class);
    }
}
