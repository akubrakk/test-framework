package io.swagger.petstore.payloads.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StoreRequest {

	@JsonProperty("petId")
	private int petId;

	@JsonProperty("quantity")
	private int quantity;

	@JsonProperty("id")
	private int id;

	@JsonProperty("shipDate")
	private String shipDate;

	@JsonProperty("complete")
	private boolean complete;

	@JsonProperty("status")
	private String status;

}