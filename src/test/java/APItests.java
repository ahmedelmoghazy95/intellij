import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APItests {
    @Test
    void test1 (){

       Response response = get("https://reqres.in/api/users?page=2");

        System.out.println("Response : " + response.asString());
        System.out.println("status code : "+ response.getStatusCode());
        System.out.println("body : "+ response.getBody().asString());
        System.out.println("time taken : "+ response.getTime());
        System.out.println("header : "+ response.getHeader("content-type"));

        int statuscode = response.statusCode();
        Assert.assertEquals(statuscode,200);

    }

    @Test
    void test2(){
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200);
        System.out.println("1st edit");
    }
}
