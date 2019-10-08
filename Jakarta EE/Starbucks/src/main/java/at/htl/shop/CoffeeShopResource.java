package at.htl.shop;

import org.eclipse.microprofile.metrics.annotation.Counted;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("drinks")
public class CoffeeShopResource {

    @Inject
    CoffeeRequest coffeeRequest;

    @GET
    public String coffees(){
        return this.coffeeRequest.fetchCoffee() + " fetched from shop";
    }
}
