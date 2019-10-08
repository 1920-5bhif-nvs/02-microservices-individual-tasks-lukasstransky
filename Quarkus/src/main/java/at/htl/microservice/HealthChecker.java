package at.htl.microservice;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Liveness
public class HealthChecker implements HealthCheck {

    @Inject
    @RestClient
    PetService petService;

    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("Server Status");
        try{
            petService.getPets();
            responseBuilder.up();
        }catch(Exception ex){
            responseBuilder.down();
        }
        return responseBuilder.build();
    }
}
