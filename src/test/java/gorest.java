import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utils.ExcelUtils;
import java.util.Random;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class gorest {

    static String userid;

    @Test(priority = 1)
    public void createUser() {

//        JSONObject request = new JSONObject();
//        request.put("name","ahmed");
//        request.put("gender","male");
//        request.put("email","kalbaz@sumerge.com");
//        request.put("status","inactive");

        Random rand = new Random();
        int uniqueNo = rand.nextInt(1000000);

        String excelpath = "./import from excel/import.xlsx";
        String sheetName = "Sheet1";

        ExcelUtils excel = new ExcelUtils(excelpath,sheetName);

        String nameKey = String.valueOf(excel.getCellData(0,0));
        String nameValue = String.valueOf(excel.getCellData(1,0));
        String emailKey = String.valueOf(excel.getCellData(0,1));
        String emailValue = String.valueOf(excel.getCellData(1,1));
        String genderKey = String.valueOf(excel.getCellData(0,2));
        String genderValue = String.valueOf(excel.getCellData(1,2));
        String statusKey = String.valueOf(excel.getCellData(0,3));
        String statusValue = String.valueOf(excel.getCellData(1,3));

        String uniqueEmail = uniqueNo + emailValue;

        JSONObject request = new JSONObject();
        request.put(nameKey,nameValue);
        request.put(genderKey,genderValue);
        request.put(emailKey,uniqueEmail);
        request.put(statusKey,statusValue);


        Response creationresponse = given().
                body(request.toString()).
                contentType(ContentType.JSON).
                baseUri("https://gorest.co.in/public/v1/users").
                queryParam("access-token","436a19d71f7980050fbcdc0e237cbf6b4b23c807d5f07d2c4ded56a8ab65238c").
                log().all().
        when().
                post().
        then().
                statusCode(201).log().all().
                and().extract().response();

        JsonPath jsonPath = creationresponse.jsonPath();
        userid = jsonPath.getString("data.id");
        System.out.println("userid is "+userid);

        }

        @Test(priority = 2)
    public void getUser() {

                given().
                accept(ContentType.JSON).
                baseUri("https://gorest.co.in/public/v1/users").
                pathParam("userid", userid).
                log().all().
        when().
                get("/{userid}").
        then().
                statusCode(200).log().all().
                body("data.name", equalTo("ahmed")).
                body("data.gender", equalTo("male")).
                body("data.email", equalTo("kalbaz@sumerge.com")).
                body("data.status", equalTo("inactive"));

        }
    @Test(priority = 3)
    public void editUser() {
        JSONObject request = new JSONObject();
        request.put("name","monika");
        request.put("gender","female");
        request.put("email","monika@sumerge.com");
        request.put("status","active");

        given().
                body(request.toJSONString()).
                contentType(ContentType.JSON).
                baseUri("https://gorest.co.in/public/v1/users").
                pathParam("userid", userid).
                log().all().
        when().
                put("/{userid}?access-token=436a19d71f7980050fbcdc0e237cbf6b4b23c807d5f07d2c4ded56a8ab65238c").
        then().
                statusCode(200).log().all();
    }
    @Test(priority = 4)
    public void checkUpdatedUser() {

        given().
                accept(ContentType.JSON).
                baseUri("https://gorest.co.in/public/v1/users").
                pathParam("userid", userid).

                log().all().
        when().
                get("/{userid}").

        then().
                statusCode(200).
                body("data.name", equalTo("monica")).
                body("data.gender", equalTo("female")).
                body("data.email", equalTo("monica@sumerge.com")).
                body("data.status", equalTo("active"));
    }
}

