
package com.commscope.bu.model;

import javax.validation.constraints.NotNull;

import com.commscope.bu.exceptionHandler.DateValidatorIntf;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;


/**
 * DocDates
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currentDate",
    "requestedShipDate",
    "requestedDeliveryDate",
    "shipDate",
    "deliveryDate"
})
public class DocDates {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("currentDate")
    @NotNull
    @DateValidatorIntf
    private String currentDate;
    @JsonProperty("requestedShipDate")
    @DateValidatorIntf
    private String requestedShipDate;
    /**
     * 
     * (Required)
     * 
     */
    @DateValidatorIntf
    @JsonProperty("requestedDeliveryDate")
    @NotNull
    private String requestedDeliveryDate;
    @JsonProperty("shipDate")
    private String shipDate;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deliveryDate")
    @NotNull
    @DateValidatorIntf
    private String deliveryDate;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("currentDate")
    public String getCurrentDate() {
        return currentDate;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("currentDate")
    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    @JsonProperty("requestedShipDate")
    public String getRequestedShipDate() {
        return requestedShipDate;
    }

    @JsonProperty("requestedShipDate")
    public void setRequestedShipDate(String requestedShipDate) {
        this.requestedShipDate = requestedShipDate;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestedDeliveryDate")
    public String getRequestedDeliveryDate() {
        return requestedDeliveryDate;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestedDeliveryDate")
    public void setRequestedDeliveryDate(String requestedDeliveryDate) {
        this.requestedDeliveryDate = requestedDeliveryDate;
    }

    @JsonProperty("shipDate")
    public String getShipDate() {
        return shipDate;
    }

    @JsonProperty("shipDate")
    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deliveryDate")
    public String getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deliveryDate")
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

}
