
package com.commscope.bu.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * billTo
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "billToName",
    "billToName2",
    "billToAddress",
    "billToAddress2",
    "billToCity",
    "billToState",
    "billToZip",
    "billToCountry"
})
public class BillTo {

    @JsonProperty("billToName")
    private String billToName;
    @JsonProperty("billToName2")
    private String billToName2;
    @JsonProperty("billToAddress")
    private String billToAddress;
    @JsonProperty("billToAddress2")
    private String billToAddress2;
    @JsonProperty("billToCity")
    private String billToCity;
    @JsonProperty("billToState")
    private String billToState;
    @JsonProperty("billToZip")
    private Double billToZip;
    @JsonProperty("billToCountry")
    private String billToCountry;

    @JsonProperty("billToName")
    public String getBillToName() {
        return billToName;
    }

    @JsonProperty("billToName")
    public void setBillToName(String billToName) {
        this.billToName = billToName;
    }

    @JsonProperty("billToName2")
    public String getBillToName2() {
        return billToName2;
    }

    @JsonProperty("billToName2")
    public void setBillToName2(String billToName2) {
        this.billToName2 = billToName2;
    }

    @JsonProperty("billToAddress")
    public String getBillToAddress() {
        return billToAddress;
    }

    @JsonProperty("billToAddress")
    public void setBillToAddress(String billToAddress) {
        this.billToAddress = billToAddress;
    }

    @JsonProperty("billToAddress2")
    public String getBillToAddress2() {
        return billToAddress2;
    }

    @JsonProperty("billToAddress2")
    public void setBillToAddress2(String billToAddress2) {
        this.billToAddress2 = billToAddress2;
    }

    @JsonProperty("billToCity")
    public String getBillToCity() {
        return billToCity;
    }

    @JsonProperty("billToCity")
    public void setBillToCity(String billToCity) {
        this.billToCity = billToCity;
    }

    @JsonProperty("billToState")
    public String getBillToState() {
        return billToState;
    }

    @JsonProperty("billToState")
    public void setBillToState(String billToState) {
        this.billToState = billToState;
    }

    @JsonProperty("billToZip")
    public Double getBillToZip() {
        return billToZip;
    }

    @JsonProperty("billToZip")
    public void setBillToZip(Double billToZip) {
        this.billToZip = billToZip;
    }

    @JsonProperty("billToCountry")
    public String getBillToCountry() {
        return billToCountry;
    }

    @JsonProperty("billToCountry")
    public void setBillToCountry(String billToCountry) {
        this.billToCountry = billToCountry;
    }

}
