package api_Method;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.API_Utilities;
import java.io.IOException;

public class get_Method {
    @Test
    public void getResponsetest() throws IOException {
        API_Utilities.readPropertyFile();
        API_Utilities.urlSetup();
       // Get Users endpoint
        String endpoint=API_Utilities.api_file.getProperty("get_user_end_point");
        //Response object
        RequestSpecification requestSpecification=RestAssured.given();
        Response response=requestSpecification.get(endpoint);

        System.out.println("Response ="+response.asString());
        //print response in console body
        System.out.println("Body = "+response.getBody().asString());
        System.out.println("Header= "+response.getHeader("content-type"));
        // status code validation
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200,"Wrong StatusCode");
        System.out.println("Status Code = "+response.getStatusCode());
    }
}
