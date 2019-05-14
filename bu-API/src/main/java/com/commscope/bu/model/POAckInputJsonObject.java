package com.commscope.bu.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Header"
})
public class POAckInputJsonObject implements InputJSONRequestIntf {
	@JsonProperty("Header")
	@Valid
	@NotNull
	private Header header;

    /**
     * Header
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("Header")
	public Header getHeader() {
		return header;
	}
    /**
     * Header
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("Header")
	public void setHeader(Header header) {
		this.header = header;
	}

	
}

 




