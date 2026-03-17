package automation.request;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;

//Clase para ejecutar solicitudes HTTP usando Rest Assured - implementa métodos generales como GET y POST pa<ra usarlos posteriormente en los tests
public class RequestBuilder {

    //Ejecuta una solicitud GET en el endpoint especificado
    public static Response getRequest(String baseUrl, String path) {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(baseUrl)
                .header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType())
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter());

        return requestSpecification.get(path);
    }

    //Ejecuta una solicitud POST en el endpoint especificado
    public static Response postRequest(String baseUrl, String path, Object body) {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(baseUrl)
                .basePath(path)
                .contentType(ContentType.APPLICATION_JSON.getMimeType())
                .body(body)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter());


        return requestSpecification.post();
    }

}
