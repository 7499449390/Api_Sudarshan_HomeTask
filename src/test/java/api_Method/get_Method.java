package api_Method;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.API_Utilities;

import java.io.IOException;

public class get_Method {

    @Feature("API_HomeTask")
    @Story("API-001: API HomeTask for get users functionality")
    @Description("To test get info of created of user")
    @Test
        public void getResponse() throws IOException {
//        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        API_Utilities.readPropertyFile();
        API_Utilities.setBaseURL();

        RequestSpecification requestSpecification=RestAssured.given();
        String endpoint="employee";
        Response response=requestSpecification.get(endpoint);


       System.out.println("Status Code = "+response.getStatusCode());
       System.out.println("Response ="+response.asString());
        System.out.println("Body = "+response.getBody().asString());
        System.out.println("Header= "+response.getHeader("content-type"));

       int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200,"Wrong StatusCode");
 }

}
