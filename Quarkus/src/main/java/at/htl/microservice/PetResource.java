package at.htl.microservice;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("api")
public class PetResource {

    @Inject
    @RestClient
    PetService petService;

    @GET
    @Path("/pets/count")
    @Produces(MediaType.TEXT_PLAIN)
    @Counted(name = "getNumberOfPets_called", description = "How often is getNumberOfPets called")
    @Timed(name= "timer", description = "How long it takes to perform the method getNumberOfPets", unit = MetricUnits.MILLISECONDS)
    public int getNumberOfPets() {
        return petService.getPets().size();
    }

    @GET
    @Path("/pets")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAnimals(){
        List<Pet> pets = petService.getPets();
        return Response.ok().entity(pets).build();
    }
}
