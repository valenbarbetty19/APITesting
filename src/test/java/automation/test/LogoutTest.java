package automation.test;
import automation.config.TestRunner;
import automation.model.LogoutUserDTO;
import automation.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LogoutTest extends TestRunner {

    //Verifica que el endpoint del logout funciona correctamente
    @Test(testName = "Verify user logout successfully")
    public void logoutUserTest() {

        Response response = RequestBuilder.getRequest(
                getBaseurl(),
                "/user/logout"
        );

        LogoutUserDTO logoutResponseDTO = response.as(LogoutUserDTO.class);

        assertEquals(response.getStatusCode(), 200, "The status code doesn't match.");
        assertEquals(logoutResponseDTO.getCode(), 200, "The code should match");
        assertEquals(logoutResponseDTO.getMessage(), "ok", "The logout message should match");
    }
}