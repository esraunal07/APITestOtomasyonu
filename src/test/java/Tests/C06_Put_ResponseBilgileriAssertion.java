package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_Put_ResponseBilgileriAssertion {

    @Test
    public void test01(){

        /*
        https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki
        Json formatindaki body ile bir PUT request gonderdigimizde
                {
                "title":"Ahmet",
                "body":"Merhaba",
                "userId":10,
                "id":70
                }
        donen Response’un,
            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve Server isimli Header’in degerinin cloudflare,
            ve status Line’in HTTP/1.1 200 OK
      */

        // 1- end point request body hazirla
        String url = "https://jsonplaceholder.typicode.com/posts/70";

        JSONObject requestbody=new JSONObject();
        requestbody.put("title", "Ahmet");
        requestbody.put("body","Merhaba");
        requestbody.put("userId",10);
        requestbody.put("id",70);

        //2-expectedbody olustur
        //3- request gonder ve donen response kaydet

        Response response= given()
                            .contentType(ContentType.JSON)
                            .when()
                            .body(requestbody.toString())
                            .put(url) ;

        //4- Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK") ;


    }
}
