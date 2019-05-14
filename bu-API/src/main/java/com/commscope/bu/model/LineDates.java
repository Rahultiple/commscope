
package com.commscope.bu.model;

import javax.validation.constraints.NotNull;

import com.commscope.bu.exceptionHandler.DateValidatorIntf;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * lineDates
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lineRequestedDeliveryDate",
    "lineRequestedShipDate"
})
public class LineDates {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineRequestedDeliveryDate")
    @NotNull
    @DateValidatorIntf
    private String lineRequestedDeliveryDate;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineRequestedShipDate")
    @NotNull
    @DateValidatorIntf
    private String lineRequestedShipDate;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineRequestedDeliveryDate")
    public String getLineRequestedDeliveryDate() {
        return lineRequestedDeliveryDate;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineRequestedDeliveryDate")
    public void setLineRequestedDeliveryDate(String lineRequestedDeliveryDate) {
        this.lineRequestedDeliveryDate = lineRequestedDeliveryDate;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineRequestedShipDate")
    public String getLineRequestedShipDate() {
        return lineRequestedShipDate;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineRequestedShipDate")
    public void setLineRequestedShipDate(String lineRequestedShipDate) {
        this.lineRequestedShipDate = lineRequestedShipDate;
    }

}
