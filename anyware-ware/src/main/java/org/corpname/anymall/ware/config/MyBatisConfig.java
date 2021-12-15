/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: MyBatisConfig
 * @packageName: org.corpname.anymall.ware.config
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:20
 **/
package org.corpname.anymall.ware.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("org.corpname.anymall.ware.dao")
public class MyBatisConfig {
    @Bean
    /**
     * @methodName: paginationInterceptor
     * @description: a pagination tool for result from mybatis
     * @param: []
     * @return: com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:20
     */
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setOverflow(true);
        paginationInterceptor.setLimit(1000);
        return paginationInterceptor;
    }
}
