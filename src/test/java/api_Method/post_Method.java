package api_Method;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.API_Utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


import static utilities.API_Utilities.api_file;

public class post_Method {
//    @BeforeClass
    public void startUp() throws IOException {
        API_Utilities.readPropertyFile();
        System.out.println(api_file.getProperty("base_url"));
        API_Utilities.urlSetup();
    }
    @Test
    public void createData() throws IOException {
        String body = Files.readString(Path.of(System.getProperty("user.dir") + "/src/test/java/api_test_data/CreateUserJsonBody.json"));
       String endpoint= api_file.getProperty("create_endpoint");
       Response response = API_Utilities.postRequest(endpoint,body);
       int statusCode = response.getStatusCode();
       Assert.assertEquals(statusCode,201,"Wrong StatusCode");

    }
}
