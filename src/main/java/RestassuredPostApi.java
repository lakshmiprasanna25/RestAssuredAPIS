import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestassuredPostApi {
    public static void main(String[] args) {
RestassuredPostApi a=new RestassuredPostApi();
String str1=a.postapi();
System.out.println(str1);
String str2=a.putapi();
        System.out.println();

    }

    public String postapi() {
        String APIBODY = "{\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "  }";
        Response response = given().header("content-type", "application/JSON")
                .baseUri("https://jsonplaceholder.typicode.com").body(APIBODY)
                .when().post("/posts").then().extract().response();

        // response.getBody().prettyPrint();
        String str = response.getBody().asString();
        System.out.println(str);
        return str;
    }

    public String putapi() {
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
        return str;
    }

    public void getapi() {
        Response resp = given().header("content-type", "application/JSON").

                when().get("https://jsonplaceholder.typicode.com/posts/1").
                then().assertThat().statusCode(200).extract().response();
        String str = resp.getBody().asString();
        //System.out.println(str);

        System.out.println(str);
    }
    public void deletapi()
    {
        Response resp = given().header("content-type","application/JSON").

                when().delete("https://jsonplaceholder.typicode.com/posts/1").then().assertThat().statusCode(200).extract().response();
        String str=resp.getBody().asString();
        //System.out.println(str);

        System.out.println(str);
    }
}


