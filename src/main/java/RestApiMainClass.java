import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

class RestApiMainClass {
    String postData = "{\n" +
            "    \"userId\": 1,\n" +
            "    \"id\": 1,\n" +
            "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
            "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
            "  }";
    String putData = "{\n" +
            "    \"userId\": 103,\n" +
            "    \"id\": 1,\n" +
            "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
            "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
            "  }";
    StringBuilder uri = new StringBuilder().append("https://jsonplaceholder.typicode.com");
    StringBuilder stringBuilder = new StringBuilder().append(postData);
    StringBuilder stringBuilder1 = new StringBuilder().append(putData);

    RequestSpecification requestSpecification = given().header("content-type", "application/JSON");

    public String postData() {
        return requestSpecification.baseUri(uri.toString()).body(stringBuilder.toString())
                .when().post("/posts").then().extract().response().getBody().asString();
    }

    public String getData() {
        return requestSpecification.when().get(uri.append("/posts/1").toString()).
                then().assertThat().statusCode(200).extract().response().getBody().asString();
    }

    public String putData() {
        return requestSpecification.baseUri(uri.toString()).body(stringBuilder1.toString())
                .when().put("/posts/1").then().extract().response().getBody().asString();
    }

    public String deleteData() {
        return requestSpecification.when().delete(uri.toString())
                .then().assertThat().statusCode(200).extract().response().getBody().asString();
    }

    public static void main(String[] args) {
        RestApiMainClass extendedClass = new RestApiMainClass();
        System.out.println(extendedClass.postData());
        System.out.println(extendedClass.putData());
        System.out.println(extendedClass.getData());
        System.out.println(extendedClass.deleteData());
    }


}


