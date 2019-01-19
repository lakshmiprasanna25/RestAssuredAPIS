import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.util.ArrayList;


public class RESTput {
    public static void main(String[] args) throws Exception {
        String APIBODY = "{\n" +
                "    \"userId\": 103,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "  }";
        Response response = given().header("content-type", "application/JSON")
                .baseUri("https://jsonplaceholder.typicode.com").body(APIBODY)
                .when().put("/posts/1").then().extract().response();

        // response.getBody().prettyPrint();
        String str = response.getBody().asString();
        System.out.println(str);
    }
}
