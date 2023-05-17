//package com.cg.ecom.ecomapp;
//
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.Optional;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.cg.ecom.dto.AddCustomersDTO;
//import com.cg.ecom.dto.CustomersDTO;
//import com.cg.ecom.entity.Customers;
//import com.cg.ecom.repository.CustomersRepository;
//import com.cg.ecom.serviceimpl.CustomersServiceImpl;
//
//@RunWith(MockitoJUnitRunner.class)
//public class CustomerMockitoTesting {
//
//    @Mock
//    private CustomersRepository customersRepository;
//
//    @InjectMocks
//    private CustomersServiceImpl customersServiceImpl;
//
//    private CustomersDTO customersDto;
//    private AddCustomersDTO addCustomersDTO;
//
//    @Before
//    public void setUp() {
//        customersDto = new CustomersDTO();
//        customersDto.setAddress("123 Main St");
//        customersDto.setCustomerId(1);
//        customersDto.setCustomerName("John Doe");
//        customersDto.setEmailId("johndoe@example.com");
//        customersDto.setMobilenumber(1234567890L);
//    }
//    
//    @Before
//    public void setUp2() {
//    	addCustomersDTO = new AddCustomersDTO();
//    	addCustomersDTO.setAddress("123 Main St");
//        customersDto.setCustomerId(1);
//        addCustomersDTO.setCustomerName("John Doe");
//        addCustomersDTO.setEmailId("johndoe@example.com");
//        addCustomersDTO.setMobilenumber(1234567890L);
//    }
//
//    @Test
//    public void testAddCustomers() {
//        Customers customers = new Customers();
//        customers.setAddress(addCustomersDTO.getAddress());
////        customers.setCustomerId(addCustomersDTO.getCustomerId());
//        customers.setCustomerName(addCustomersDTO.getCustomerName());
//        customers.setEmailId(addCustomersDTO.getEmailId());
//        customers.setMobilenumber(addCustomersDTO.getMobilenumber());
//
//        when(customersRepository.save(customers)).thenReturn(customers);
//
//        CustomersDTO result = customersServiceImpl.addCustomers(addCustomersDTO);
//
//        assertEquals(addCustomersDTO, result);
//    }
//}
