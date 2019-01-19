
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RESTpost {



        public static void main(String[] args) throws Exception{
            String APIBODY="{\n" +
                    "    \"userId\": 1,\n" +
                    "    \"id\": 1,\n" +
                    "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                    "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                    "  }";
            Response response= given().header("content-type","application/JSON")
                    .baseUri("https://jsonplaceholder.typicode.com").body(APIBODY)
                    .when().post("/posts").then().extract().response();

            // response.getBody().prettyPrint();
            String str = response.getBody().asString();
            System.out.println(str);



        }
    }

