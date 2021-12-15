/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: OrderEntity
 * @packageName: org.corpname.anymall.product.entity
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:39
 **/
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

    /**
     * id
     */
    private Long id;
    /**
     * order_sn
     */
    private String orderSn;
    /**
     * owner
     */
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
    /**
     * originated
     */
    private Date originated;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+2")
    /**
     * originated
     */
    private Date modified;
}
