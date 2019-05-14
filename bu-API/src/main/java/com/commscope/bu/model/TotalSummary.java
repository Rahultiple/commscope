
package com.commscope.bu.model;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * TotalSummary
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "SummaryTotal"
})
public class TotalSummary {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("SummaryTotal")
    @NotNull
    private Double summaryTotal;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("SummaryTotal")
    public Double getSummaryTotal() {
        return summaryTotal;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("SummaryTotal")
    public void setSummaryTotal(Double summaryTotal) {
        this.summaryTotal = summaryTotal;
    }

}
