package automation.test;

import automation.config.TestRunner;
import automation.model.LoginUserDTO;
import automation.request.RequestBuilder;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest extends TestRunner {
    @Test
    public void loginUserTest(){

        Response response = RequestBuilder.getRequest(
                getBaseurl(),
                "/user/login?username=ValenBarbie&password=jajaj123"
        );
        LoginUserDTO loginUserDTO = response.as(LoginUserDTO.class);

        assertEquals(response.getStatusCode(), 200, "The status code doesn't match.");
        assertEquals(loginUserDTO.getCode(), 200, "The code should match");
        assertTrue(loginUserDTO.getMessage().contains("logged in"),
                "The login message should contain 'logged in'");
    }
}
