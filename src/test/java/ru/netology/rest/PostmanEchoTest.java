
package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    void test1() { //Вводим текст, должны получить такой же
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("Hello") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("Hello"))
        ;
    }

}
//Если соберётесь отправлять текст не на латинице, то вам нужно будет выставлять кодировку, например, UTF-8:
//
//given()
//  .baseUri("https://postman-echo.com")
//  .contentType("text/plain; charset=UTF-8") -> Вот такую
//  .body("some data")
//.when()
//  .post("/post")
//.then()
//  .statusCode(200)
//  .body(/* --> ваша проверка здесь <-- */)
//;