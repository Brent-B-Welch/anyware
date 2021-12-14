-- DROP DATABASE IF EXISTS anyware_ware;
/*==============================================================*/
/* Table: ware_order                                              */
/*==============================================================*/
DROP TABLE IF EXISTS oms_order;

CREATE TABLE oms_order
(
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    order_sn VARCHAR(255) COMMENT 'order sn',
    owner VARCHAR(255) DEFAULT 'guest' COMMENT 'owner of the order',
    order_status TINYINT(8)  COMMENT 'order status',
    originated DATETIME COMMENT 'timestamp to created the order',
    modified DATETIME DEFAULT now() COMMENT 'modified',
    PRIMARY KEY (id)
);
ALTER TABLE oms_order COMMENT 'Inventory Information';
/*==============================================================*/
/* Table: oms_order_item                                          */
/*==============================================================*/
DROP TABLE IF EXISTS oms_order_item;

CREATE TABLE oms_order_item
(
    id BIGINT NOT NULL AUTO_INCREMENT  COMMENT 'id',
    order_id BIGINT COMMENT 'order_id',
    order_sn VARCHAR(255) COMMENT 'order_sn',
    product_id BIGINT COMMENT 'product ID',
    quantity INT COMMENT 'quantity of ordered product',
    order_item_status TINYINT(8)  COMMENT 'order item status',
    PRIMARY KEY (id)
);

ALTER TABLE oms_order_item COMMENT 'Order Item Information';
/*==============================================================*/
/* Table: oms_order_task                                  */
/*==============================================================*/
DROP TABLE IF EXISTS oms_order_task;

CREATE TABLE oms_order_task
(
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    order_id BIGINT COMMENT 'order_id',
    order_sn VARCHAR(255) COMMENT 'order_sn',
    task_status TINYINT(8)  COMMENT 'task status',
    originated DATETIME COMMENT 'timestamp to created the task',
    modified DATETIME DEFAULT now() COMMENT 'modified',
    task_comment VARCHAR(500) COMMENT 'task COMMENT',
    PRIMARY KEY (id)
);
ALTER TABLE oms_order_task COMMENT 'Ware Order Task';

/*==============================================================*/
/* Table: oms_ware_order_operate_history                       */
/*==============================================================*/
DROP TABLE IF EXISTS oms_ware_order_operate_history;

CREATE TABLE oms_ware_order_operate_history
(
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    owner VARCHAR(255) DEFAULT 'guest' COMMENT 'operator',
    order_status TINYINT(8)  COMMENT 'order status',
    originated DATETIME COMMENT 'timestamp for the operation',
    modified DATETIME DEFAULT now() COMMENT 'modified',
    PRIMARY KEY (id)
);

ALTER TABLE oms_ware_order_operate_history COMMENT 'Ware Order Task History';