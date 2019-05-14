
package com.commscope.bu.model;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * LineDetail
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lineNumber",
    "lineQuantity",
    "lineUOM",
    "linePrice",
    "linePricePerUnit",
    "lineCustMaterial",
    "lineVendMaterial",
    "lineMaterialDescription"
})
public class LineDetail {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineNumber")
    @NotNull
    private Double lineNumber;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineQuantity")
    @NotNull
    private Double lineQuantity;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineUOM")
    @NotNull
    private String lineUOM;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("linePrice")
    @NotNull
    private Double linePrice;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("linePricePerUnit")
    @NotNull
    private Double linePricePerUnit;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineCustMaterial")
    @NotNull
    private String lineCustMaterial;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineVendMaterial")
    @NotNull
    private String lineVendMaterial;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineMaterialDescription")
    @NotNull
    private String lineMaterialDescription;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineNumber")
    public Double getLineNumber() {
        return lineNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineNumber")
    public void setLineNumber(Double lineNumber) {
        this.lineNumber = lineNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineQuantity")
    public Double getLineQuantity() {
        return lineQuantity;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineQuantity")
    public void setLineQuantity(Double lineQuantity) {
        this.lineQuantity = lineQuantity;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineUOM")
    public String getLineUOM() {
        return lineUOM;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineUOM")
    public void setLineUOM(String lineUOM) {
        this.lineUOM = lineUOM;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("linePrice")
    public Double getLinePrice() {
        return linePrice;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("linePrice")
    public void setLinePrice(Double linePrice) {
        this.linePrice = linePrice;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("linePricePerUnit")
    public Double getLinePricePerUnit() {
        return linePricePerUnit;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("linePricePerUnit")
    public void setLinePricePerUnit(Double linePricePerUnit) {
        this.linePricePerUnit = linePricePerUnit;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineCustMaterial")
    public String getLineCustMaterial() {
        return lineCustMaterial;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineCustMaterial")
    public void setLineCustMaterial(String lineCustMaterial) {
        this.lineCustMaterial = lineCustMaterial;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineVendMaterial")
    public String getLineVendMaterial() {
        return lineVendMaterial;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineVendMaterial")
    public void setLineVendMaterial(String lineVendMaterial) {
        this.lineVendMaterial = lineVendMaterial;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineMaterialDescription")
    public String getLineMaterialDescription() {
        return lineMaterialDescription;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineMaterialDescription")
    public void setLineMaterialDescription(String lineMaterialDescription) {
        this.lineMaterialDescription = lineMaterialDescription;
    }

}
