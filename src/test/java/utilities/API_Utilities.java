package utilities;


import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class API_Utilities {
    public static Properties api_file;
    public static Response response;
    public static void readPropertyFile() throws IOException {
        api_file = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\java\\resources\\api_configs.properties");
        api_file.load(file);
        System.out.println(file);
    }
    public static void urlSetup(){
        RestAssured.baseURI=api_file.getProperty("base_url");
    }

    public static Response postRequest(String body,String endpoint){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Accept","application/json");
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.body(body);
        Response response=requestSpecification.post(endpoint);
        return response;
    }








}
