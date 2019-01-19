import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
public class GeoCodingPost {
    public static void main(String[] args)
    {
        String str1="key:tkb4Jr0R6u8O2DGpwayZZV1oymxPuz17";
        Response resp=given().header("content-type","application/JSON").
                queryParam("key","tkb4Jr0R6u8O2DGpwayZZV1oymxPuz17").queryParam("location","30.333472,-81.470448").
                baseUri("http://www.mapquestapi.com/").
                when().get("geocoding/v1/reverse").
                then().assertThat().statusCode(200).extract().response();
        String str=resp.getBody().asString();
        JsonPath json=new JsonPath(str);
        ArrayList<Integer> list=json.get("results.locations.postalCode[0]");
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
    }
}
