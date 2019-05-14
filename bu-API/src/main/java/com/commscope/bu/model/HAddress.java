
package com.commscope.bu.model;

import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * HAddress
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "shipTo",
    "shipFrom",
    "soldTo",
    "billTo",
    "thirdParty"
})
public class HAddress {

    /**
     * shipTo
     * <p>
     * 
     * 
     */
    @JsonProperty("shipTo")
    @Valid
    private ShipTo shipTo;
    /**
     * shipFrom
     * <p>
     * 
     * 
     */
    @JsonProperty("shipFrom")
    @Valid
    private ShipFrom shipFrom;
    /**
     * soldTo
     * <p>
     * 
     * 
     */
    @JsonProperty("soldTo")
    @Valid
    private SoldTo soldTo;
    /**
     * billTo
     * <p>
     * 
     * 
     */
    @JsonProperty("billTo")
    @Valid
    private BillTo billTo;
    /**
     * thirdParty
     * <p>
     * 
     * 
     */
    @JsonProperty("thirdParty")
    @Valid
    private ThirdParty thirdParty;

    /**
     * shipTo
     * <p>
     * 
     * 
     */
    @JsonProperty("shipTo")
    public ShipTo getShipTo() {
        return shipTo;
    }

    /**
     * shipTo
     * <p>
     * 
     * 
     */
    @JsonProperty("shipTo")
    public void setShipTo(ShipTo shipTo) {
        this.shipTo = shipTo;
    }

    /**
     * shipFrom
     * <p>
     * 
     * 
     */
    @JsonProperty("shipFrom")
    public ShipFrom getShipFrom() {
        return shipFrom;
    }

    /**
     * shipFrom
     * <p>
     * 
     * 
     */
    @JsonProperty("shipFrom")
    public void setShipFrom(ShipFrom shipFrom) {
        this.shipFrom = shipFrom;
    }

    /**
     * soldTo
     * <p>
     * 
     * 
     */
    @JsonProperty("soldTo")
    public SoldTo getSoldTo() {
        return soldTo;
    }

    /**
     * soldTo
     * <p>
     * 
     * 
     */
    @JsonProperty("soldTo")
    public void setSoldTo(SoldTo soldTo) {
        this.soldTo = soldTo;
    }

    /**
     * billTo
     * <p>
     * 
     * 
     */
    @JsonProperty("billTo")
    public BillTo getBillTo() {
        return billTo;
    }

    /**
     * billTo
     * <p>
     * 
     * 
     */
    @JsonProperty("billTo")
    public void setBillTo(BillTo billTo) {
        this.billTo = billTo;
    }

    /**
     * thirdParty
     * <p>
     * 
     * 
     */
    @JsonProperty("thirdParty")
    public ThirdParty getThirdParty() {
        return thirdParty;
    }

    /**
     * thirdParty
     * <p>
     * 
     * 
     */
    @JsonProperty("thirdParty")
    public void setThirdParty(ThirdParty thirdParty) {
        this.thirdParty = thirdParty;
    }

}
