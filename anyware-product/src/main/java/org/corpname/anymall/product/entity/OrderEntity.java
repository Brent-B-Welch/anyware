package org.corpname.anymall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("oms_order")
public class OrderEntity {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String orderSn;
    private String owner;
    /**
     * TODO: this will be replaced by Enum
     *
     * INIT(1)
     * IN_PROCESS(2)
     * COMPLETED(3)
     * CANCELLED(4)
     */
    private Integer orderStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+2")
    private Date originated;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+2")
    private Date modified;
}
