package io.swagger.petstore.services.pet;

import io.qameta.allure.Step;
import io.swagger.petstore.assertions.AssertableResponse;
import io.swagger.petstore.services.ApiService;

import java.io.File;


public class PetApiService extends ApiService {

   @Step
    public AssertableResponse postPetPetIdUploadImage(int petId,
                                                      String additionalMetadata,
                                                      String filePath){
return new AssertableResponse(requestMultipart()
        .pathParam("petId",petId)
        .param("additionalMetadata",additionalMetadata)
        .multiPart("file", new File(filePath))
        .when()
        .post("pet/{petId}/uploadImage"));
   }
    @Step
    public AssertableResponse getPetById(int petId){
        return new AssertableResponse(requestMultipart()
                .pathParam("petId",petId)
                .when()
                .get("pet/{petId}"));
    }
}
