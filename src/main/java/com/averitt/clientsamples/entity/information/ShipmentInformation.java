package com.averitt.clientsamples.entity.information;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@ToString
@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
public class ShipmentInformation
{
    private String pieces;
    private String weight;
    private String bolNumber;
    private Set<String> poNumbers;
    private String hazmat;
}