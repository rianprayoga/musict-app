package com.example.spotmusic.dummy;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private String customerName;
    private List<AddressDTO> addressList;
//    private String shippingStreetAddress;
//    private String shippingCity;
//    private String billingStreetAddress;
//    private String billingCity;
}
