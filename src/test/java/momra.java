import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class momra {

    static String t1 ;
    static String t2 ;
    @Test
    public void extractTokens() {
        JSONObject request = new JSONObject();
        request.put("email", "mohsen@gmail.com");
        request.put("empId", "132");
        request.put("engineeringOfficeId", "132");
        request.put("fullName", "mohsen");
        request.put("mobile", "01234567891");
        request.put("nationalId", "29501300101599");
        request.put("userType", "backend");

        Response tokensResponse = given().
                body(request.toJSONString()).
                contentType(ContentType.JSON).
                baseUri("http://api.momra.gov.local/auth/tokens/test").
                log().all().
        when().
                post().
        then().
                statusCode(200).log().all().
                and().extract().response();

        JsonPath jsonPath = tokensResponse.jsonPath();
        t1 = jsonPath.getString("t1");
        t2 = jsonPath.getString("t2");
        System.out.println("t1 is " + t1 + " and t2 is " + t2);
    }


    @Test
    public void retrieveList() {
        given().
                accept(ContentType.JSON).
                baseUri("http://api.momra.gov.local/engineering-offices/offices").
                queryParams("t1",t1,"t2",t2).
                log().all().
        when().
                get().
        then().
                statusCode(200).log().all();
    }
}
