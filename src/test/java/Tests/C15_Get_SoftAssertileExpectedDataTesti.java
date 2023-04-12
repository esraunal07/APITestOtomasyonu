package Tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C15_Get_SoftAssertileExpectedDataTesti {
    @Test
    public void test01(){
         /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
     */

        //1- end point ve request body olustur
        String url = "http://dummy.restapiexample.com/api/v1/employee/3 ";

        //2-Expected data olustur

        JSONObject expectedData=new JSONObject();
        JSONObject dataBilgileriJSon=new JSONObject();

        dataBilgileriJSon.put("id",3);
        dataBilgileriJSon.put("employee_name","Ashton Cox");
        dataBilgileriJSon.put("employee_salary",86000);
        dataBilgileriJSon.put("employee_age",66);
        dataBilgileriJSon.put("profile_image","");

        expectedData.put("status","success");
        expectedData.put("data",dataBilgileriJSon);
        expectedData.put("message","Successfully! Record has been fetched.");

      //  System.out.println(expectedData.toString());

        //3- Request gonderip donen response kaydet

        Response response = given().when().get(url);

        //4- Assertion

        //Oncelikle response uzerindeki bilgileri kolay almak icin
        //JSonPath'e cast edelim

        JsonPath responseJSonPath=response.jsonPath();

        //Assertionlari soft assert ile yapalim

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(responseJSonPath.get("status"),expectedData.get("status"));
        softAssert.assertEquals(responseJSonPath.get("message"),expectedData.get("message"));
        softAssert.assertEquals(responseJSonPath.get("data.employee_name"),expectedData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(responseJSonPath.get("data.employee_salary"),expectedData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(responseJSonPath.get("data.employee_age"),expectedData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(responseJSonPath.get("data.profile_image"),expectedData.getJSONObject("data").get("profile_image"));
        softAssert.assertAll();









    }
}
