package Tests;

import BaseUrl.JSonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceholder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_Put_DeSerialization extends JSonPlaceHolderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body’e sahip bir PUT request yolladigimizda donen response’in
    response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Expected Data :
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */
    @Test
    public void put01(){

        //1- url ve body hazirla

       specJsonPlaceholder.pathParams("pp1","posts","pp2",70);

        TestDataJsonPlaceholder testDataJsonPlaceholder=new TestDataJsonPlaceholder();
        HashMap<String,Object> reqbody=testDataJsonPlaceholder.requestBodyOlusturMap();

        //2- Expected Data hazirla

        HashMap<String,Object> expBody =testDataJsonPlaceholder.requestBodyOlusturMap();

        //3- Response kaydet

        Response response=given()
                .spec(specJsonPlaceholder)
                .contentType(ContentType.JSON)
                .when()
                .body(reqbody)
                .put("/{pp1}/{pp2}");
        response.prettyPeek();

        //4- Assertion yapabılmemız ıcın response ı mape cevırmemız lazım

        HashMap<String,Object>respMap=response.as(HashMap.class);
        assertEquals(testDataJsonPlaceholder.basariliStatusCode,response.getStatusCode());
        assertEquals(expBody.get("id"),respMap.get("id"));
        assertEquals(expBody.get("title"),respMap.get("title"));
        assertEquals(expBody.get("body"),respMap.get("body"));
        assertEquals(expBody.get("userId"),respMap.get("userId"));


}

}
