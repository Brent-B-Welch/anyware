/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: JacksonConfig
 * @packageName: org.corpname.anymall.ware.config
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:20
 **/
package org.corpname.anymall.ware.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Slf4j
@Configuration
public class JacksonConfig {

    @Bean
    /**
     * @methodName: getObjectMapper
     * @description: enable pretty format for json
     * @param: []
     * @return: com.fasterxml.jackson.databind.ObjectMapper
     * @throws:
     * @author: Beiji Ma
     * @date: 2021-12-15 16:21
     */
    public ObjectMapper getObjectMapper() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return mapper;
    }

}
