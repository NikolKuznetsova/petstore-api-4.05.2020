import io.restassured.RestAssured;
import org.junit.Test;

public class PetTests {

    @Test
    public void getPetById(){
        RestAssured //код ниже написан через билдер
                .given()// переключает билдер на работу с реквестом
                .log().all() //логируется, распечатывается весь реквест
                .baseUri("https://petstore.swagger.io/v2") //базовая часть урла
                .get("/pet/666") //параметр урла и метод http - get
                .then() // переключает билдер на работу с респонсом
                .log().all()//логируется, распечатывается весь респонс
                .statusCode(200); //проверка статус кода
    }
}
