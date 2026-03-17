package automation.test;

import automation.config.TestRunner;
import automation.model.PetDTO;
import automation.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GetPetById extends TestRunner {
    //Valida que el endpoint GET de obtener una mascota por id funcione correctamente, validando un unhappy path con una mascota que no existe petId = 0
    @Test
    public void getPetByIdTest(){
        Response response = RequestBuilder.getRequest(
                getBaseurl(),
                "/pet/0"
        );

        PetDTO petDTO = response.as(PetDTO.class);

        assertEquals(response.getStatusCode(), 404, "Status code doesn't match");
        assertEquals(petDTO.getId(), 0, "The pet id should match");
    }
}
