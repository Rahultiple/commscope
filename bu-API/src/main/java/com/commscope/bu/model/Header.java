
package com.commscope.bu.model;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Header
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "APartyDetails",
    "CType",
    "DocDates",
    "HDetail",
    "HAddress",
    "TotalSummary",
    "LINE"
})
public class Header {

    /**
     * APartyDetails
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("APartyDetails")
    @Valid
    @NotNull(message="APartyDetails")
    private APartyDetails aPartyDetails;
    /**
     * CType
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CType")
    @Valid
    @NotNull(message="CType")
    private CType cType;
    /**
     * DocDates
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DocDates")
    @Valid
    @NotNull(message="DocDates")
    private DocDates docDates;
    /**
     * HDetail
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HDetail")
    @Valid
    @NotNull(message="HDetail")
    private HDetail hDetail;
    /**
     * HAddress
     * <p>
     * 
     * 
     */
    @JsonProperty("HAddress")
    @Valid
    private HAddress hAddress;
    /**
     * TotalSummary
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TotalSummary")
    @Valid
    @NotNull(message="TotalSummary")
    private TotalSummary totalSummary;
    /**
     * LINE
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LINE")
    @Valid
    @NotNull(message="LINE")
    private List<Line> line = null;

    /**
     * APartyDetails
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("APartyDetails")
    public APartyDetails getAPartyDetails() {
        return aPartyDetails;
    }

    /**
     * APartyDetails
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("APartyDetails")
    public void setAPartyDetails(APartyDetails aPartyDetails) {
        this.aPartyDetails = aPartyDetails;
    }

    /**
     * CType
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CType")
    public CType getCType() {
        return cType;
    }

    /**
     * CType
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CType")
    public void setCType(CType cType) {
        this.cType = cType;
    }

    /**
     * DocDates
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DocDates")
    public DocDates getDocDates() {
        return docDates;
    }

    /**
     * DocDates
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DocDates")
    public void setDocDates(DocDates docDates) {
        this.docDates = docDates;
    }

    /**
     * HDetail
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HDetail")
    public HDetail getHDetail() {
        return hDetail;
    }

    /**
     * HDetail
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HDetail")
    public void setHDetail(HDetail hDetail) {
        this.hDetail = hDetail;
    }

    /**
     * HAddress
     * <p>
     * 
     * 
     */
    @JsonProperty("HAddress")
    public HAddress getHAddress() {
        return hAddress;
    }

    /**
     * HAddress
     * <p>
     * 
     * 
     */
    @JsonProperty("HAddress")
    public void setHAddress(HAddress hAddress) {
        this.hAddress = hAddress;
    }

    /**
     * TotalSummary
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TotalSummary")
    public TotalSummary getTotalSummary() {
        return totalSummary;
    }

    /**
     * TotalSummary
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TotalSummary")
    public void setTotalSummary(TotalSummary totalSummary) {
        this.totalSummary = totalSummary;
    }

    /**
     * LINE
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LINE")
    public List<Line> getLine() {
        return line;
    }

    /**
     * LINE
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LINE")
    public void setLine(List<Line> line) {
        this.line = line;
    }

}
