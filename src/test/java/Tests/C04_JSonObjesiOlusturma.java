package Tests;

import org.json.JSONObject;
import org.junit.Test;

public class C04_JSonObjesiOlusturma {
    @Test
    public void test01(){
        /*
                {
                "title":"Ahmet",
                "body":"Merhaba",
                "userId":10,

                }
         */
        JSONObject obj1 =new JSONObject();
        obj1.put("title", "Ahmet");
        obj1.put("body", "Merhaba");
        obj1.put("userId",1);
        System.out.println(obj1);
    }
}