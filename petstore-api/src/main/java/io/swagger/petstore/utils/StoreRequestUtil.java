package io.swagger.petstore.utils;

import com.github.javafaker.Faker;
import io.swagger.petstore.payloads.store.StoreRequest;
import lombok.experimental.UtilityClass;


import static io.swagger.petstore.constants.GeneralConstants.ORDER_STATUS;
import static io.swagger.petstore.constants.GeneralConstants.SHIP_DATE;


@UtilityClass
public class StoreRequestUtil{
    public static final Faker faker = new Faker();

    public static StoreRequest getRandomOrder(){
        StoreRequest storeRequest = new StoreRequest();
        storeRequest.setId(faker.random().nextInt(0, 10));
        storeRequest.setPetId(faker.random().nextInt(1, 10));
        storeRequest.setQuantity(faker.random().nextInt(1, 100));
        storeRequest.setShipDate(SHIP_DATE);
        storeRequest.setStatus(ORDER_STATUS);
        storeRequest.setComplete(faker.bool().bool());
        return storeRequest;
    }

}
