import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestApiMain {

    public static void main(String[] args) {
        String postData="{\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "  }";
        String putData="{\n" +
                "    \"userId\": 103,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "  }";
        RequestSpecification requestSpecification = given().header("content-type", "application/JSON");
        Response postResponse = requestSpecification.baseUri("https://jsonplaceholder.typicode.com").body(postData)
                .when().post("/posts").then().extract().response();


        Response getResponse = requestSpecification.when().get("https://jsonplaceholder.typicode.com/posts/1").
                then().assertThat().statusCode(200).extract().response();

        Response putResponse = requestSpecification.baseUri("https://jsonplaceholder.typicode.com").body(putData)
                .when().put("/posts/1").then().extract().response();

        Response deleteResponse = requestSpecification.when().delete("https://jsonplaceholder.typicode.com/posts/1")
                .then().assertThat().statusCode(200).extract().response();

        Map<String, String> map = new HashMap<String, String>();
        map.put("postDataResponse", postResponse.getBody().asString());
        map.put("getDataResponse", getResponse.getBody().asString());
        map.put("putDataResponse", putResponse.getBody().asString());
        map.put("deleteDataResponse", deleteResponse.getBody().asString());
        System.out.println(map);
    }
}
