package apitests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class simpleGetRequest {
    String cyberUrl="http://api.cybertektraining.com";


    @Test
    public  void test1(){
        Response response = RestAssured.get(cyberUrl);
        System.out.println(response.statusCode());
        response.prettyPrint();
    }

    @Test
    public  void test2(){

      Response response=  RestAssured.given().accept(ContentType.JSON)
                .when().get(cyberUrl);


           Assert.assertEquals(response.statusCode(),200);
        System.out.println(response.contentType());
        Assert.assertEquals(response.contentType(),"application/json;charset=UTF-8");
    }

    @Test
    public  void test3(){

        RestAssured.given().accept(ContentType.JSON)
                .when().get(cyberUrl).then().assertThat().statusCode(200)
                .and().contentType("application/json;charset=UTF-8");
    }

    @Test
    public  void test4(){
        Response response=RestAssured.given().accept(ContentType.JSON)
                .when().get(cyberUrl+"/student/all");
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json;charset=UTF-8");

        response.body().asString().contains("Ell");
    }
}
