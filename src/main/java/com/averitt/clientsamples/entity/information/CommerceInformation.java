package com.averitt.clientsamples.entity.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
public class CommerceInformation
{ 
    private String terms;
    private String grossCharges;
    private String discount;
    private String fuelSurcharge;
    private String netCharges;
}