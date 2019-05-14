
package com.commscope.bu.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;


/**
 * APartyDetails
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Sender",
    "Receiver"
})
public class APartyDetails {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Sender")
    @NotEmpty(message="Sender")
    private String sender;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Receiver")
    @NotEmpty(message="Receiver")
    private String receiver;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Sender")
    public String getSender() {
        return sender;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Sender")
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Receiver")
    public String getReceiver() {
        return receiver;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Receiver")
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

}
