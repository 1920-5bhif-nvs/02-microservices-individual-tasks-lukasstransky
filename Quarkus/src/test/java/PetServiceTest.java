
import at.htl.microservice.Pet;
import at.htl.microservice.PetService;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;

@QuarkusTest
public class PetServiceTest {

    @Inject
    @RestClient
    PetService service;

    @Test
    public void testPetServiceGetPets(){
        List<Pet> pets = service.getPets();
        Assertions.assertEquals(5, pets.size());

        Assertions.assertEquals("Lilly", pets.get(0).getName());
        Assertions.assertEquals(789, pets.get(0).getPrice());

        Assertions.assertEquals("Timmy", pets.get(1).getName());
        Assertions.assertEquals(200, pets.get(1).getPrice());

        Assertions.assertEquals("Jessy", pets.get(2).getName());
        Assertions.assertEquals(255, pets.get(2).getPrice());

        Assertions.assertEquals("Luna", pets.get(3).getName());
        Assertions.assertEquals(150, pets.get(3).getPrice());

        Assertions.assertEquals("Rocky", pets.get(4).getName());
        Assertions.assertEquals(430, pets.get(4).getPrice());
    }
}
