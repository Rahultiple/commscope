
package com.commscope.bu.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "LineDetail",
    "lineDates"
})
public class Line {

    /**
     * LineDetail
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LineDetail")
    @Valid
    @NotNull(message="LineDetail")
    private LineDetail lineDetail;
    /**
     * lineDates
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineDates")
    @Valid
    @NotNull
    private LineDates lineDates;

    /**
     * LineDetail
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LineDetail")
    public LineDetail getLineDetail() {
        return lineDetail;
    }

    /**
     * LineDetail
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LineDetail")
    public void setLineDetail(LineDetail lineDetail) {
        this.lineDetail = lineDetail;
    }

    /**
     * lineDates
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineDates")
    public LineDates getLineDates() {
        return lineDates;
    }

    /**
     * lineDates
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("lineDates")
    public void setLineDates(LineDates lineDates) {
        this.lineDates = lineDates;
    }

}
