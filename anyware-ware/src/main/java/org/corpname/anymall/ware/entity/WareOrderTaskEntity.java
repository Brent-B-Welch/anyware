/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: WareOrderTaskEntity
 * @packageName: org.corpname.anymall.ware.entity
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:22
 **/
package org.corpname.anymall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Builder
@Data
@TableName("ware_order_task")
public class WareOrderTaskEntity {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * order_id
     */
    private Long orderId;
    /**
     * order_sn
     */
    private String orderSn;
    /**
     * task_status
     */
    private Integer taskStatus;
    /**
     * task_comment
     */
    private String taskComment;
    /**
     * originated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+2")
    private Date originated;
    /**
     * modified
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+2")
    private Date modified;
}
