package Tests;

import BaseUrl.JSonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.Assert;
import testData.TestDataJsonPlaceholder;

import static io.restassured.RestAssured.given;

public class C18_Get_TestDataClassKullanimi extends JSonPlaceHolderBaseUrl {
       /*
  https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
  request yolladigimizda donen response’in status kodunun 200 ve
  response body’sinin asagida verilen ile ayni oldugunu test ediniz
   Response body :
    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */

    @Test
    public void get01(){

        // 1 - URL hazirla

        specJsonPlaceholder.pathParams("pp1","posts","pp2",22);

        // 2 - Expected Data hazirla

        TestDataJsonPlaceholder testDataJsonPlaceHolder = new TestDataJsonPlaceholder();

        JSONObject expData = testDataJsonPlaceHolder.expectedBodyOlusturJSON();

        // 3 - Response'i kaydet

        Response response = given().spec(specJsonPlaceholder).when().get("/{pp1}/{pp2}");

        // 4 - Assertion

        JsonPath resJPath = response.jsonPath();

        Assert.assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        Assert.assertEquals(expData.get("userId"),resJPath.get("userId"));
        Assert.assertEquals(expData.get("id"),resJPath.get("id"));
        Assert.assertEquals(expData.get("title"),resJPath.get("title"));
        Assert.assertEquals(expData.get("body"),resJPath.get("body"));
    }
}
