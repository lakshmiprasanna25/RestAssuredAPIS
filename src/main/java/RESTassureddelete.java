import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RESTassureddelete {
    public static void main(String[] args)
    {
        Response resp = given().header("content-type","application/JSON").

                when().delete("https://jsonplaceholder.typicode.com/posts/1").then().assertThat().statusCode(200).extract().response();
        String str=resp.getBody().asString();
        //System.out.println(str);

        System.out.println(str);


    }
}
