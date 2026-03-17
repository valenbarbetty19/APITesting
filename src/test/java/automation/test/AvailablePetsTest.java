package automation.test;

import automation.config.TestRunner;
import automation.model.PetDTO;
import automation.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AvailablePetsTest extends TestRunner {
    @Test
    public void listAvailablePets(){
        Response response = RequestBuilder.getRequest(
                getBaseurl(),
                "/pet/findByStatus?status=available"
        );

        PetDTO[] pets = response.as(PetDTO[].class);

        assertEquals(response.getStatusCode(), 200, "The status code doesn't match");
        assertEquals(pets[0].getStatus(), "available", "The pet status should be available");
    }
}
