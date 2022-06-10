package utilities;


import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class API_Utilities {
    public static Properties api_file;
    public static void readPropertyFile() throws IOException {
        api_file = new Properties();
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\java\\resources\\api_configs.properties");
        api_file.load(objfile);
        System.out.println(objfile);
    }
    public static void setBaseURL() throws IOException {
        //RestAssured.baseURI = "https://gorest.co.in/public/v2";
        RestAssured.baseURI = api_file.getProperty("base_url");

    }
    }
