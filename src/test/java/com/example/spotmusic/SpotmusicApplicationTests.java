package com.example.spotmusic;

import com.example.spotmusic.dummy.Address;
import com.example.spotmusic.dummy.Customer;
import com.example.spotmusic.dummy.Order;
import com.example.spotmusic.dummy.OrderDTO;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpotmusicApplicationTests {

	@Test
	void contextLoads() {

		Address shippingAddress = new Address("Magelang Street","Magelang");
		Address billingAddress = new Address("Negara Street","Magelang");
		List<Address> addressList = List.of(shippingAddress, billingAddress);
		Customer customer = new Customer("John");
		Order order = new Order(customer, addressList);

		ModelMapper modelMapper = new ModelMapper();
		OrderDTO dto = modelMapper.map(order, OrderDTO.class);

		assert dto.getCustomerName().equals(order.getCustomer().getName());
//		assert dto.ge
//		assert dto.getShippingStreetAddress().equals(order.getShippingAddress().getStreet());
//		assert dto.getShippingCity().equals(order.getShippingAddress().getCity());
//		assert dto.getBillingStreetAddress().equals(order.getBillingAddress().getStreet());
//		assert dto.getBillingCity().equals(order.getBillingAddress().getCity());
	}

}
