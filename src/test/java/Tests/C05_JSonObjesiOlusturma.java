package Tests;

import org.json.JSONObject;
import org.junit.Test;

public class C05_JSonObjesiOlusturma {
    @Test
    public void Test02(){

        /*
        {
    "firstname": "Mary",
    "additionalneeds": "Breakfast",
    "bookingdates": {
        "checkin": "2016-09-06",
        "checkout": "2017-07-10"
    },
    "totalprice": 925,
    "depositpaid": true,
     "lastname": "Ericsson",
     }
         */

        //Once inner Json objesini olusturalim
        JSONObject dateJSonObject = new JSONObject();
        dateJSonObject.put("checkin", "2016-09-06");
        dateJSonObject.put("checkout","2017-07-10");
        //Sonra outer json objesini olusturalim, yeri geldiginde inner objeyi koyalim
        JSONObject requestBody=new JSONObject();

        requestBody.put("firstname","Mary");
        requestBody.put("additionalneeds","Breakfast");
        requestBody.put("bookingdates",dateJSonObject) ;
        requestBody.put("totalprice",925);
        requestBody.put("depositpaid",true);
        requestBody.put("lastname","Ericsson");

        System.out.println(requestBody);


    }
}
