package io.swagger.petstore.tests.store;

import io.swagger.petstore.conditions.Conditions;
import org.testng.annotations.Test;

import static io.swagger.petstore.utils.StoreRequestUtil.getRandomOrder;
import static org.apache.http.HttpStatus.SC_OK;

public class PostOrderTest extends StoreBaseTest{

    @Test
    public void testPostOrder(){
        storeApiService.postOrder(getRandomOrder())
                .shouldHave(Conditions.statusCode(SC_OK));
    }
}
