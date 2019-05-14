
package com.commscope.bu.model;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * HDetail
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "PONumber",
    "shipmentNumber",
    "deliveryNumber",
    "InvoiceNumber",
    "salesOrderNumber",
    "currency",
    "emailAddress"
})
public class HDetail {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("PONumber")
    @NotNull(message="PONumber")
    private Double pONumber;
    @JsonProperty("shipmentNumber")
    private Double shipmentNumber;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deliveryNumber")
    @NotNull
    private Double deliveryNumber;
    @JsonProperty("InvoiceNumber")
    private Double invoiceNumber;
    @JsonProperty("salesOrderNumber")
    private Double salesOrderNumber;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    @NotNull
    private String currency;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("emailAddress")
    @NotNull
    private String emailAddress;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("PONumber")
    public Double getPONumber() {
        return pONumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("PONumber")
    public void setPONumber(Double pONumber) {
        this.pONumber = pONumber;
    }

    @JsonProperty("shipmentNumber")
    public Double getShipmentNumber() {
        return shipmentNumber;
    }

    @JsonProperty("shipmentNumber")
    public void setShipmentNumber(Double shipmentNumber) {
        this.shipmentNumber = shipmentNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deliveryNumber")
    public Double getDeliveryNumber() {
        return deliveryNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("deliveryNumber")
    public void setDeliveryNumber(Double deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    @JsonProperty("InvoiceNumber")
    public Double getInvoiceNumber() {
        return invoiceNumber;
    }

    @JsonProperty("InvoiceNumber")
    public void setInvoiceNumber(Double invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @JsonProperty("salesOrderNumber")
    public Double getSalesOrderNumber() {
        return salesOrderNumber;
    }

    @JsonProperty("salesOrderNumber")
    public void setSalesOrderNumber(Double salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("emailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("emailAddress")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
