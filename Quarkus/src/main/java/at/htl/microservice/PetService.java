package at.htl.microservice;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pets")
@RegisterRestClient
public interface PetService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Pet> getPets();
}
