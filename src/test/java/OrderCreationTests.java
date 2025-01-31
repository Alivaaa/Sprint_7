import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import model.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import steps.OrderApiSteps;
import java.net.HttpURLConnection;
import static constants.UrlConstants.*;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class OrderCreationTests {
    @Parameterized.Parameter
    public Order order;
    private OrderApiSteps orderApiSteps;

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = ORDERS_API;
        orderApiSteps = new OrderApiSteps();
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {new Order("Test1", "Param1", "Addr Param1, 123", "11", "123-456-7890", 1, "2025-10-10", "Test comment param1", new String[]{})},
                {new Order("Test2", "Param2", "Addr Param2, 456", "12", "098-765-4321", 3, "2025-11-15", "Test comment param2", new String[]{"BLACK"})},
                {new Order("Test3", "Param3", "Addr Param3, 789", "13", "567-890-1234", 5, "2025-12-05", "Test comment param3", new String[]{"GREY"})},
                {new Order("Test4", "Param4", "Addr Param4, 101", "14", "234-567-8901", 7, "2025-09-20", "Test comment param4", new String[]{"BLACK", "GREY"})}
        };
    }

    @Test
    @DisplayName("Успешное создание заказа")
    public void testCreateOrder() {
        orderApiSteps.setOrder(order);
        orderApiSteps.createOrder()
                .then().log().all()
                .assertThat().statusCode(HttpURLConnection.HTTP_CREATED)
                .body("track", notNullValue());
    }
}