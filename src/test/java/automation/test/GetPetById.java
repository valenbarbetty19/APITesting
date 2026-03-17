package automation.test;

import automation.config.TestRunner;
import automation.model.PetDTO;
import automation.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GetPetById extends TestRunner {
    @Test
    public void getPetByIdTest(){
        Response response = RequestBuilder.getRequest(
                getBaseurl(),
                "/pet/1"
        );

        PetDTO petDTO = response.as(PetDTO.class);

        assertEquals(response.getStatusCode(), 200, "Status code doesn't match");
        assertEquals(petDTO.getId(), 1, "The pet id should match");
    }
}
