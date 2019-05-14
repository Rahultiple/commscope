
package com.commscope.bu.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * shipFrom
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "shipFromName",
    "shipFromName2",
    "shipFromAddress",
    "shipFromAddress2",
    "shipFromCity",
    "shipFromState",
    "shipFromZip",
    "shipFromCountry"
})
public class ShipFrom {

    @JsonProperty("shipFromName")
    private String shipFromName;
    @JsonProperty("shipFromName2")
    private String shipFromName2;
    @JsonProperty("shipFromAddress")
    private String shipFromAddress;
    @JsonProperty("shipFromAddress2")
    private String shipFromAddress2;
    @JsonProperty("shipFromCity")
    private String shipFromCity;
    @JsonProperty("shipFromState")
    private String shipFromState;
    @JsonProperty("shipFromZip")
    private String shipFromZip;
    @JsonProperty("shipFromCountry")
    private String shipFromCountry;

    @JsonProperty("shipFromName")
    public String getShipFromName() {
        return shipFromName;
    }

    @JsonProperty("shipFromName")
    public void setShipFromName(String shipFromName) {
        this.shipFromName = shipFromName;
    }

    @JsonProperty("shipFromName2")
    public String getShipFromName2() {
        return shipFromName2;
    }

    @JsonProperty("shipFromName2")
    public void setShipFromName2(String shipFromName2) {
        this.shipFromName2 = shipFromName2;
    }

    @JsonProperty("shipFromAddress")
    public String getShipFromAddress() {
        return shipFromAddress;
    }

    @JsonProperty("shipFromAddress")
    public void setShipFromAddress(String shipFromAddress) {
        this.shipFromAddress = shipFromAddress;
    }

    @JsonProperty("shipFromAddress2")
    public String getShipFromAddress2() {
        return shipFromAddress2;
    }

    @JsonProperty("shipFromAddress2")
    public void setShipFromAddress2(String shipFromAddress2) {
        this.shipFromAddress2 = shipFromAddress2;
    }

    @JsonProperty("shipFromCity")
    public String getShipFromCity() {
        return shipFromCity;
    }

    @JsonProperty("shipFromCity")
    public void setShipFromCity(String shipFromCity) {
        this.shipFromCity = shipFromCity;
    }

    @JsonProperty("shipFromState")
    public String getShipFromState() {
        return shipFromState;
    }

    @JsonProperty("shipFromState")
    public void setShipFromState(String shipFromState) {
        this.shipFromState = shipFromState;
    }

    @JsonProperty("shipFromZip")
    public String getShipFromZip() {
        return shipFromZip;
    }

    @JsonProperty("shipFromZip")
    public void setShipFromZip(String shipFromZip) {
        this.shipFromZip = shipFromZip;
    }

    @JsonProperty("shipFromCountry")
    public String getShipFromCountry() {
        return shipFromCountry;
    }

    @JsonProperty("shipFromCountry")
    public void setShipFromCountry(String shipFromCountry) {
        this.shipFromCountry = shipFromCountry;
    }

}
