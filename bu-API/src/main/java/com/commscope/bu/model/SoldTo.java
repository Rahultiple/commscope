
package com.commscope.bu.model;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * soldTo
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "soldToName",
    "soldToName2",
    "soldToAddress",
    "soldToAddress2",
    "soldToCity",
    "soldToState",
    "soldToZip",
    "soldToCountry"
})
public class SoldTo {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("soldToName")
    @NotNull
    private String soldToName;
    @JsonProperty("soldToName2")
    private String soldToName2;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("soldToAddress")
    @NotNull
    private String soldToAddress;
    @JsonProperty("soldToAddress2")
    private String soldToAddress2;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("soldToCity")
    @NotNull
    private String soldToCity;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("soldToState")
    @NotNull
    private String soldToState;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("soldToZip")
    @NotNull
    private Double soldToZip;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("soldToCountry")
    @NotNull
    private String soldToCountry;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("soldToName")
    public String getSoldToName() {
        return soldToName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("soldToName")
    public void setSoldToName(String soldToName) {
        this.soldToName = soldToName;
    }

    @JsonProperty("soldToName2")
    public String getSoldToName2() {
        return soldToName2;
    }

    @JsonProperty("soldToName2")
    public void setSoldToName2(String soldToName2) {
        this.soldToName2 = soldToName2;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("soldToAddress")
    public String getSoldToAddress() {
        return soldToAddress;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("soldToAddress")
    public void setSoldToAddress(String soldToAddress) {
        this.soldToAddress = soldToAddress;
    }

    @JsonProperty("soldToAddress2")
    public String getSoldToAddress2() {
        return soldToAddress2;
    }

    @JsonProperty("soldToAddress2")
    public void setSoldToAddress2(String soldToAddress2) {
        this.soldToAddress2 = soldToAddress2;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("soldToCity")
    public String getSoldToCity() {
        return soldToCity;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("soldToCity")
    public void setSoldToCity(String soldToCity) {
        this.soldToCity = soldToCity;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("soldToState")
    public String getSoldToState() {
        return soldToState;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("soldToState")
    public void setSoldToState(String soldToState) {
        this.soldToState = soldToState;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("soldToZip")
    public Double getSoldToZip() {
        return soldToZip;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("soldToZip")
    public void setSoldToZip(Double soldToZip) {
        this.soldToZip = soldToZip;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("soldToCountry")
    public String getSoldToCountry() {
        return soldToCountry;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("soldToCountry")
    public void setSoldToCountry(String soldToCountry) {
        this.soldToCountry = soldToCountry;
    }

}
