package delivery.api;

import delivery.dto.OrderDto;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import delivery.utils.ApiClient;

public class OrderTest extends BaseSetupApi {

    @Test
    void getOrderInformationAndCheckResponse() {

        Response response = ApiClient.getOrders( getAuthenticatedRequestSpecification() );

        Assertions.assertAll("Test description",
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Status code is OK")
        );
    }

    @Test
    void getOrdersArrayInformationAndCheckResponse() {
        OrderDto[] ordersResponse = ApiClient.getOrdersArray( getAuthenticatedRequestSpecification() );
        for (int orderIteration = 0; orderIteration < ordersResponse.length; orderIteration++){
            System.out.println( "Order id: " + ordersResponse[orderIteration].getId() );
        }

    }

    @Test
    void createOrderAndCheckResponse() {

        // order creation
        OrderDto orderDto = OrderDto.createRandomOrder();
        Response response = ApiClient.createOrder(getAuthenticatedRequestSpecification(), orderDto );

        Assertions.assertAll("Test description",
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Status code is OK"),
                () -> Assertions.assertNotNull(response.getBody().path("id")),
                () -> Assertions.assertNull(response.getBody().path("courierId"))
        );
    }
}
