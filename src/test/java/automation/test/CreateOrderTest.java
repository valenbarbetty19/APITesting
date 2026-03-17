package automation.test;

import automation.config.TestRunner;
import automation.model.OrderDTO;
import automation.request.RequestBuilder;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CreateOrderTest extends TestRunner {

    //Valida la creación de una orden para una mascota en específico
    @Test
    public void createOrderTest(){
        OrderDTO orderDTO = OrderDTO.builder()
                .id(1)
                .petId(1)
                .quantity(2)
                .shipDate("2026-03-17T03:25:58.378Z")
                .status("placed")
                .complete(true)
                .build();
        Response response = RequestBuilder.postRequest(
                getBaseurl(),
                "/store/order",
                orderDTO
        );
        OrderDTO orderResponse = response.as(OrderDTO.class);

        assertEquals(response.getStatusCode(), 200);


    }
}
