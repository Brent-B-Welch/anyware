/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: OrderOperationHistoryEntity
 * @packageName: org.corpname.anymall.product.entity
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:41
 **/
package org.corpname.anymall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("oms_ware_order_operate_history")
public class OrderOperationHistoryEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;
    /**
     * owner
     */
    private String owner;
    /**
     * order_status
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
     * modified
     */
    private Date modified;
}
