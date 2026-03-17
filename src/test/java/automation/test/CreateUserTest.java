package automation.test;

import automation.config.TestRunner;
import automation.model.CreateUserDTO;
import automation.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CreateUserTest extends TestRunner {

    //Verifica que un usuario se cree de manera correcta - Flujo: 1. Crea un usuario 2. Manda el POST request al endpoint especificado 3. Valida que la respuesta sea 200
    @Test(testName = "Validate user creation")
    public void createUserTest(){
        CreateUserDTO createUserDTO = CreateUserDTO.builder()
                .id(1001)
                .username("ValenBarbie")
                .firstName("Valentina")
                .lastName("Barbetty")
                .email("valenbarb@gmail.com")
                .password("jajaj123")
                .phone("123456789")
                .userStatus(1).build();
        Response response = RequestBuilder.postRequest(getBaseurl(), "/user", createUserDTO);
        assertEquals(response.getStatusCode(), 200);
    }
}
