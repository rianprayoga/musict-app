package com.example.spotmusic.dummy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private Customer customer;
    private List<Address> addressList;
//    private Address shippingAddress;
//    private Address billingAddress;
}
