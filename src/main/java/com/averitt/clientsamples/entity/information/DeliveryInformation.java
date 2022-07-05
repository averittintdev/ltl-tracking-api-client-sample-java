package com.averitt.clientsamples.entity.information;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
public class DeliveryInformation
{
    private String consigneeName;

    @JsonSerialize(using=LocalDateTimeSerializer.class)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateTime;

    private String deliveryPoint;
    private String serviceCenter;
    private String deliveryName;
}