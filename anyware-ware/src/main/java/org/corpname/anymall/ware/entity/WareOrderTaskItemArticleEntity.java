/**
 * @projectName: anyware
 * @version: v0.0.1
 * @className: WareOrderTaskItemArticleEntity
 * @packageName: org.corpname.anymall.ware.entity
 * @description: TODO Class description
 * @author: Beiji Ma
 * @date:  2021-12-15 16:23
 **/
package org.corpname.anymall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("ware_order_task_item_article")
public class WareOrderTaskItemArticleEntity {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * product_id
     */
    private Long productId;

    /**
     * art_id
     */
    private Long artId;

    /**
     * quantity
     */
    private Integer amountOf;
    /**
     * status
     */
    private Integer status;
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
