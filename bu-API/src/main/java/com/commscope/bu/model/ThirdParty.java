
package com.commscope.bu.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * thirdParty
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "thrdPartyName",
    "thrdPartyName2",
    "thrdPartyAddress",
    "thrdPartyAddress2",
    "thrdPartyCity",
    "thrdPartyState",
    "thrdPartyZip",
    "thrdPartyCountry"
})
public class ThirdParty {

    @JsonProperty("thrdPartyName")
    private String thrdPartyName;
    @JsonProperty("thrdPartyName2")
    private String thrdPartyName2;
    @JsonProperty("thrdPartyAddress")
    private String thrdPartyAddress;
    @JsonProperty("thrdPartyAddress2")
    private String thrdPartyAddress2;
    @JsonProperty("thrdPartyCity")
    private String thrdPartyCity;
    @JsonProperty("thrdPartyState")
    private String thrdPartyState;
    @JsonProperty("thrdPartyZip")
    private String thrdPartyZip;
    @JsonProperty("thrdPartyCountry")
    private String thrdPartyCountry;

    @JsonProperty("thrdPartyName")
    public String getThrdPartyName() {
        return thrdPartyName;
    }

    @JsonProperty("thrdPartyName")
    public void setThrdPartyName(String thrdPartyName) {
        this.thrdPartyName = thrdPartyName;
    }

    @JsonProperty("thrdPartyName2")
    public String getThrdPartyName2() {
        return thrdPartyName2;
    }

    @JsonProperty("thrdPartyName2")
    public void setThrdPartyName2(String thrdPartyName2) {
        this.thrdPartyName2 = thrdPartyName2;
    }

    @JsonProperty("thrdPartyAddress")
    public String getThrdPartyAddress() {
        return thrdPartyAddress;
    }

    @JsonProperty("thrdPartyAddress")
    public void setThrdPartyAddress(String thrdPartyAddress) {
        this.thrdPartyAddress = thrdPartyAddress;
    }

    @JsonProperty("thrdPartyAddress2")
    public String getThrdPartyAddress2() {
        return thrdPartyAddress2;
    }

    @JsonProperty("thrdPartyAddress2")
    public void setThrdPartyAddress2(String thrdPartyAddress2) {
        this.thrdPartyAddress2 = thrdPartyAddress2;
    }

    @JsonProperty("thrdPartyCity")
    public String getThrdPartyCity() {
        return thrdPartyCity;
    }

    @JsonProperty("thrdPartyCity")
    public void setThrdPartyCity(String thrdPartyCity) {
        this.thrdPartyCity = thrdPartyCity;
    }

    @JsonProperty("thrdPartyState")
    public String getThrdPartyState() {
        return thrdPartyState;
    }

    @JsonProperty("thrdPartyState")
    public void setThrdPartyState(String thrdPartyState) {
        this.thrdPartyState = thrdPartyState;
    }

    @JsonProperty("thrdPartyZip")
    public String getThrdPartyZip() {
        return thrdPartyZip;
    }

    @JsonProperty("thrdPartyZip")
    public void setThrdPartyZip(String thrdPartyZip) {
        this.thrdPartyZip = thrdPartyZip;
    }

    @JsonProperty("thrdPartyCountry")
    public String getThrdPartyCountry() {
        return thrdPartyCountry;
    }

    @JsonProperty("thrdPartyCountry")
    public void setThrdPartyCountry(String thrdPartyCountry) {
        this.thrdPartyCountry = thrdPartyCountry;
    }

}
