import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestassuredPosts1Api {

    public static void main(String[] args)
        {
            Response resp = given().header("content-type","application/JSON").
                    when().get("https://jsonplaceholder.typicode.com/posts").then().assertThat().statusCode(200).extract().response();
            String str=resp.getBody().asString();
            System.out.println(str);
            //JsonPath jpath=new JsonPath(str);
            //System.out.println(jpath.get("results.locations.geocodeQuality"));



        }
    }


