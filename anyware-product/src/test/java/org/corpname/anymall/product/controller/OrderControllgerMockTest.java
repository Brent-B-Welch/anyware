package org.corpname.anymall.product.controller;


import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: OrderControllgerMockTest
 * @packageName: org.corpname.anymall.product.controller
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date: 2021-12-15 22:08
 **/
public class OrderControllgerMockTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void listOrder() throws Exception {
        String uri = "/order/order/";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}
