package testData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataJsonPlaceholder {
    public static int basariliStatusCode = 200;
    public static String contentType = "application/json; charset=utf-8";
    public static String connectionHeaderDegeri = "keep-alive";

    public JSONObject expectedBodyOlusturJSON (){

        JSONObject expBodyJson = new JSONObject();

        expBodyJson.put("userId",3.0);
        expBodyJson.put("id",22.0);
        expBodyJson.put("title","dolor sint quo a velit explicabo quia nam");
        expBodyJson.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis" +
                " non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expBodyJson;
    }

    public JSONObject requestBodyOlusturJSON (){

        JSONObject reqBodyJson = new JSONObject();

        reqBodyJson.put("userId",10.0);
        reqBodyJson.put("id",70.0);
        reqBodyJson.put("title","Ali");
        reqBodyJson.put("body","Merhaba");

        return reqBodyJson;
    }


    public HashMap requestBodyOlusturMap (){

        HashMap<String,Object> requestBodyMap = new HashMap<>();

        requestBodyMap.put("title","Ahmet");
        requestBodyMap.put("body","Merhaba");
        requestBodyMap.put("userId",10.0);
        requestBodyMap.put("id",70.0);

        return requestBodyMap;
    }
}
