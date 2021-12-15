package org.corpname.anymall.product;

import org.corpname.anymall.product.service.OrderService;
import org.corpname.anymall.product.vo.OrderInDetailVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @projectName: AnymallProductApplicationMockitoTest
 * @version: v0.0.1
 * @className: DemoApplication
 * @packageName: org.corpname.anymall.product
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date: 2021-12-15 21:25
 **/
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class AnymallProductApplicationMockitoTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void test() {
        Date now = new Date();
        OrderInDetailVo vo = OrderInDetailVo.builder()
                .id(1L)
                .modified(now)
                .originated(now)
                .build();

        Mockito.when(orderService.getOrderInDetail(1L))
                .thenReturn(vo);
        OrderInDetailVo anOrderInDetailVo = orderService.getOrderInDetail(1L);
        Assert.assertEquals(vo, anOrderInDetailVo);
    }
}
