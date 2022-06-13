package api_Method;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.API_Utilities;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static utilities.API_Utilities.api_file;
public class post_Method {
    @BeforeClass
    public void startUp() throws Exception {
        API_Utilities.readPropertyFile();
        //  System.out.println(api_file.getProperty("base_url"));
        API_Utilities.urlSetup1();
    }
    @Test
    public void createData() throws IOException {
        String body = Files.readString(Path.of(System.getProperty("user.dir") + "\\src\\test\\java\\api_test_data\\CreateUserJsonBody.json"));
        // Get Users endpoint
        String endpoint= api_file.getProperty("create_endpoint");

        Response response = API_Utilities.postRequest(body,"https://reqres.in/api/users");
        // status code validation
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201,"Wrong StatusCode");

        String name =  response.getBody().jsonPath().getJsonObject("name").toString();
        //Print name in console window
        System.out.println("name is ="+name);

        String email =  response.getBody().jsonPath().getJsonObject("email").toString();
        //Print emailID in console window
        System.out.println("email is ="+email);

        String gender =  response.getBody().jsonPath().getJsonObject("gender").toString();
        //Print gender in console window
        System.out.println("gender is ="+gender);

        String status =  response.getBody().jsonPath().getJsonObject("status").toString();
        //Print status of person in console window
        System.out.println("status is ="+status);
    }
}
