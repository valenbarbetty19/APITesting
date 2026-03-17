package automation.request;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;

public class RequestBuilder {

    public static Response getRequest(String baseUrl, String path) {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(baseUrl)
                .header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType())
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter());



        return requestSpecification.get(path);
    }

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

    public static Response deleteRequest(String baseUrl, String path, Integer id) {
        RequestSpecification requestSpecification = RestAssured.given()
                .pathParam("idUser", id)
                .baseUri(baseUrl)
                .basePath(path)
                .header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType())
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter());


        return requestSpecification.delete("/{idUser}");
    }
}
