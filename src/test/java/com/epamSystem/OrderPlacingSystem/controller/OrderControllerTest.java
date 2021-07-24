package com.epamSystem.OrderPlacingSystem.controller;

import com.epamSystem.OrderPlacingSystem.Service.OrderService;
import com.epamSystem.OrderPlacingSystem.vo.BillDetails;
import com.epamSystem.OrderPlacingSystem.vo.Order;
import com.epamSystem.OrderPlacingSystem.vo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OrderController.class)
public class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void generateBillTest() throws Exception {
        String uri = "/api/v1/order/generateBill";
        String exampleOrderJson = "{\"orderId\":\"1\",\"productDetails\":[{\"itemName\":\"Apple\",\"quantity\":\"5\",\"price\":\"5\",\"amount\":\"\",\"offer\":\"true\"},{\"itemName\":\"Orange\",\"quantity\":\"8\",\"price\":\"3\",\"amount\":\"\",\"offer\":\"true\"}]}";
        Product p1 = new Product("Apple",5,5.0,15.0);
        Product p2 = new Product("Orange",8,3.0,18.0);
        p1.setOffer(true);
        p2.setOffer(true);
        BillDetails mockBillDetails = new BillDetails("1", Arrays.asList(p1,p2),33.0);
        Mockito.when(
                orderService.calculateBill(Mockito.any(Order.class))).thenReturn(mockBillDetails);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE).content(exampleOrderJson).contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String expectedResult = "{\"orderId\": \"1\",\"productDetails\": [{\"itemName\": \"Apple\",\"quantity\": 5,\"price\": 5.0,\"amount\": 15.0},{\"itemName\": \"Orange\",\"quantity\": 8,\"price\": 3.0,\"amount\": 18.0}],\"grandTotal\": 33.0}";
        JSONAssert.assertEquals(expectedResult,mvcResult.getResponse().getContentAsString(),false);
    }
}
