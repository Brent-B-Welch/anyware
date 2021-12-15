/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: AnymallProductApplication
 * @packageName: org.corpname.anymall.product
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:30
 **/
package org.corpname.anymall.product;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2Doc
public class AnymallProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnymallProductApplication.class, args);
    }
}
