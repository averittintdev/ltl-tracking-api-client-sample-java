package com.averitt.clientsamples.entity;

import com.averitt.clientsamples.entity.information.AppointmentInformation;
import com.averitt.clientsamples.entity.information.BillToInformation;
import com.averitt.clientsamples.entity.information.CommerceInformation;
import com.averitt.clientsamples.entity.information.DeliveryInformation;
import com.averitt.clientsamples.entity.information.EstimatedServiceTime;
import com.averitt.clientsamples.entity.information.PickupInformation;
import com.averitt.clientsamples.entity.information.ShipmentHistory;
import com.averitt.clientsamples.entity.information.ShipmentInformation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class ProDetails
{
    private String status;
    private String proNumber;
    private String shipmentType;
    private LinkedList<String> associatedPros;
    private EstimatedServiceTime estimatedServiceTime;
    private PickupInformation pickupInformation;
    private DeliveryInformation deliveryInformation;
    private ShipmentInformation shipmentInformation;
    private AppointmentInformation appointmentInformation;
    private BillToInformation billToInformation;
    private CommerceInformation commerceInformation;
    private LinkedList<ShipmentHistory> shipmentHistory;
}