package Tests;

import BaseUrl.JSonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PojoJsonPlaceholder;
import testData.TestDataJsonPlaceholder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_PojoClass extends JSonPlaceHolderBaseUrl {
     /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body'e sahip bir PUT
    request yolladigimizda donen response'in
    status code nun 200,
    content type'inin "application/json; charset=utf-8",
    Connection header degerinin "keep-alive"
    ve response body'sinin asagida verilen ile ayni oldugunu
    test ediniz.
    Request Body
    {
    "title" :"Ahmet",
    "body"  :"Merhaba",
    "userId":10,
    "id" :70
    }
    Expected
    {
    "title" :"Ahmet",
    "body"  :"Merhaba",
    "userId":10,
    "id" :70
    }
    */

    @Test
    public void test01(){

        // 1- endpoint ve request body olustur

        specJsonPlaceholder.pathParams("pp1","posts","pp2","70");

        PojoJsonPlaceholder requestBodyPojo = new PojoJsonPlaceholder("Ahmet","Merhaba",10,70);

        // 2- Soruda varsa expected data olustur

        PojoJsonPlaceholder expectedDataPojo = new PojoJsonPlaceholder("Ahmet","Merhaba",10,70);

        // 3- Request gonder donen response'i kaydet

        Response response = given().spec(specJsonPlaceholder).contentType(ContentType.JSON)
                .when().body(requestBodyPojo)
                .put("{pp1}/{pp2}");
        PojoJsonPlaceholder responsePojo=response.as(PojoJsonPlaceholder.class);
        // 4- Assertion

        // expected data (Pojo) <=====> response (Pojo)
        // expectedDataPojo     <=====> responsePojo

        //status code nun 200,
        assertEquals(TestDataJsonPlaceholder.basariliStatusCode,response.statusCode());

        //content type'inin "application/json; charset=utf-8",

        assertEquals(TestDataJsonPlaceholder.contentType,response.contentType());
        //Connection header degerinin "keep-alive"
        assertEquals(TestDataJsonPlaceholder.connectionHeaderDegeri,response.header("Connection"));

        //ve response body'sinin asagida verilen ile ayni oldugunu test ediniz

        assertEquals(expectedDataPojo.getTitle(), responsePojo.getTitle());
        assertEquals(expectedDataPojo.getBody(), responsePojo.getBody());
        assertEquals(expectedDataPojo.getUserId(), responsePojo.getUserId());
        assertEquals(expectedDataPojo.getId(), responsePojo.getId());

    }


}
