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
public class BillToInformation
{
    private String billTo;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
}