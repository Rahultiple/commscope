
package com.commscope.bu.model;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * CType
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Doctype",
    "Vertype",
    "SEmail"
})
public class CType {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Doctype")
    @NotNull(message="Doctype")
    private String doctype;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Vertype")
    @NotNull(message="Vertype")
    private Double vertype;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("SEmail")
    @NotNull(message="SEmail")
    private String sEmail;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Doctype")
    public String getDoctype() {
        return doctype;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Doctype")
    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Vertype")
    public Double getVertype() {
        return vertype;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("Vertype")
    public void setVertype(Double vertype) {
        this.vertype = vertype;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("SEmail")
    public String getSEmail() {
        return sEmail;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("SEmail")
    public void setSEmail(String sEmail) {
        this.sEmail = sEmail;
    }

}
