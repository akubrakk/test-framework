package io.swagger.petstore.tests.pet;

import org.testng.annotations.Test;

import static io.swagger.petstore.conditions.Conditions.statusCode;
import static org.apache.http.HttpStatus.SC_OK;

public class GetPetByIdTest extends PetBaseTest {
    @Test
    public void testPostPetPetIdUploadImage(){

        petApiService.getPetById(5)
                .shouldHave(statusCode(SC_OK));

    }
}
