package api_Method;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.API_Utilities;

import java.io.IOException;

public class post_Method {
    @BeforeClass
    public void startUp() throws IOException {
        API_Utilities.readPropertyFile();
        API_Utilities.setBaseURL();
    }
    @Feature("API_HomeTask")
    @Story("API-002: API HomeTask for Update users functionality")
    @Description("To test new user is created ")
    @Test
    public void createData() {
        RestAssured.baseURI="base_url";
        RequestSpecification httpRequest=RestAssured.given();

        JSONObject parameter = new JSONObject();

        parameter.put("name", "morpheus");
        parameter.put("job", "leader");

        System.out.println("Name and Job ="+parameter);
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(parameter.toString());
        Response response=httpRequest.request(Method.POST,"/users");

        System.out.println("Status Code = "+response.getStatusCode());
        System.out.println("Response ="+response.asString());
        System.out.println("Body = "+response.getBody().asString());
        System.out.println("Header= "+response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201,"Wrong StatusCode");

    }
}
