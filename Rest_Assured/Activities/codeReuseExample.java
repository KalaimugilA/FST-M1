package Activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RedirectSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class codeReuseExample {


    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    @BeforeClass
    public void setUp() {

        requestSpec = new RequestSpecBuilder()
                       .setBaseUri("https://petstore.swagger.io/v2/pet")
                .setContentType(ContentType.JSON)
                .build();

        responseSpec =new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectBody("status",equalTo("alive"))
                .expectBody("name",equalTo("Riley"))
                .build();

    }

    @Test(priority = 1)
    public void postRequestTest()
    {   String reqBody = "{\"id\": 77232, \"name\": \"Riley\", \"status\": \"alive\"}";

        Response response =given().spec(requestSpec)
                .log().all()
                .body(reqBody)
                .when().post();

        response.then().spec(responseSpec);
    }
    @Test(priority = 2)
    public void getRequestTest()
    {  //Generate response
        Response response =given().spec(requestSpec)
                               .when().get("/77232");

        //Assertions
        response.then().spec(responseSpec);
    }


    @Test(priority = 3)
    public void deleteRequestTest()
    {  //Generate response
        Response response =given().spec(requestSpec)
                .when().delete("/77232");

        //Assertions
        response.then().statusCode(200);
        response.then().body("message",equalTo("77232"));
    }
}