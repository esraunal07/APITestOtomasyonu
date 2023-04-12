package Tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetRequest_ResponseBilgilerininTestEdilmesi {

    @Test
    public void test01(){
         /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
        gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK oldugunu
        ve response suresinin 5sn'den kisa oldugunu manuel olarak test edin.

     */
        // 1 - Gerekli olan URL ve Body hazirla

        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2 - Soruda isteniyorsa Expected Data hazirla

        // 3 - Donen Response'i kaydet

        Response response = given().when().get(url);
        response.prettyPrint();

        System.out.println("status code : " + response.getStatusCode()+
                            "\nContent type :" + response.getContentType()+
                            "\nServer Header degeri :" + response.getHeader("Server")+
                            "\nStatus Line :" + response.getStatusLine()+
                            "\nResponse Suresi:" + response.getTime());

        // 4 - Assertion


    }
}
