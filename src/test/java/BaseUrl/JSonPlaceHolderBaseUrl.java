package BaseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JSonPlaceHolderBaseUrl {
    protected static RequestSpecification specJsonPlaceholder;
    @Before
    public void setup(){
        specJsonPlaceholder= new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
    }

}
