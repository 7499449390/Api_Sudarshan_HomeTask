package api_Method;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.API_Utilities;
import java.io.IOException;
import static utilities.API_Utilities.api_file;

public class get_Method {
    @Test
    public void getResponsetest() throws IOException {
      API_Utilities.readPropertyFile();
      API_Utilities.urlSetup();
      System.out.println(api_file.getProperty("base_url"));
      String endpoint=API_Utilities.api_file.getProperty("create_user_end_point");
      RequestSpecification requestSpecification=RestAssured.given();
      Response response=requestSpecification.get(endpoint);

      System.out.println("Status Code = "+response.getStatusCode());
      System.out.println("Response ="+response.asString());
      System.out.println("Body = "+response.getBody().asString());
      System.out.println("Header= "+response.getHeader("content-type"));

      int statusCode = response.getStatusCode();
       Assert.assertEquals(statusCode,200,"Wrong StatusCode");
 }

}
