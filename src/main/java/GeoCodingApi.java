

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GeoCodingApi {
 public static void main(String[] args)
 {
     Response resp = given().header("content-type","application/JSON")
             .queryParam("key","tkb4Jr0R6u8O2DGpwayZZV1oymxPuz17").
                     queryParam("location","Bengaluru").baseUri("http://www.mapquestapi.com/").
             when().get("geocoding/v1/address").then().assertThat().statusCode(200).extract().response();
     String str=resp.getBody().asString();
     //System.out.println(str);
     JsonPath jpath=new JsonPath(str);
     System.out.println(jpath.get("results.locations.geocodeQuality"));


 }
}
