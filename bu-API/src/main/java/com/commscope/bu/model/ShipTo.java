
package com.commscope.bu.model;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * shipTo
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "shipToName",
    "shipToName2",
    "shipToAddress",
    "shipToAddress2",
    "shipToCity",
    "shipToState",
    "shipToZip",
    "shipToCountry"
})
public class ShipTo {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shipToName")
    @NotNull
    private String shipToName;
    @JsonProperty("shipToName2")
    private String shipToName2;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shipToAddress")
    @NotNull
    private String shipToAddress;
    @JsonProperty("shipToAddress2")
    private String shipToAddress2;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shipToCity")
    @NotNull
    private String shipToCity;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shipToState")
    @NotNull
    private String shipToState;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shipToZip")
    @NotNull
    private Double shipToZip;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shipToCountry")
    @NotNull
    private String shipToCountry;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shipToName")
    public String getShipToName() {
        return shipToName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shipToName")
    public void setShipToName(String shipToName) {
        this.shipToName = shipToName;
    }

    @JsonProperty("shipToName2")
    public String getShipToName2() {
        return shipToName2;
    }

    @JsonProperty("shipToName2")
    public void setShipToName2(String shipToName2) {
        this.shipToName2 = shipToName2;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shipToAddress")
    public String getShipToAddress() {
        return shipToAddress;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shipToAddress")
    public void setShipToAddress(String shipToAddress) {
        this.shipToAddress = shipToAddress;
    }

    @JsonProperty("shipToAddress2")
    public String getShipToAddress2() {
        return shipToAddress2;
    }

    @JsonProperty("shipToAddress2")
    public void setShipToAddress2(String shipToAddress2) {
        this.shipToAddress2 = shipToAddress2;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shipToCity")
    public String getShipToCity() {
        return shipToCity;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shipToCity")
    public void setShipToCity(String shipToCity) {
        this.shipToCity = shipToCity;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shipToState")
    public String getShipToState() {
        return shipToState;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shipToState")
    public void setShipToState(String shipToState) {
        this.shipToState = shipToState;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shipToZip")
    public Double getShipToZip() {
        return shipToZip;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shipToZip")
    public void setShipToZip(Double shipToZip) {
        this.shipToZip = shipToZip;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shipToCountry")
    public String getShipToCountry() {
        return shipToCountry;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shipToCountry")
    public void setShipToCountry(String shipToCountry) {
        this.shipToCountry = shipToCountry;
    }

}
