package org.corpname.anymall.ware;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2Doc
public class AnymallWareApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnymallWareApplication.class, args);
    }
}
