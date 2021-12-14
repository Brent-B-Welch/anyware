-- DROP DATABASE IF EXISTS anyware_ware;
/*==============================================================*/
/* Table: ware_sku                                              */
/*==============================================================*/
DROP TABLE IF EXISTS ware_sku;

CREATE TABLE ware_sku
(
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    art_id BIGINT COMMENT 'article id',
    name VARCHAR(200) COMMENT 'article name',
    stock INT COMMENT 'stock',
--    deleted TINYINT DEFAULT 1 COMMENT 'status',
    PRIMARY KEY (id)
);
ALTER TABLE ware_sku COMMENT 'Inventory Information';
/*==============================================================*/
/* Table: ware_article                                          */
/*==============================================================*/
DROP TABLE IF EXISTS ware_article;

CREATE TABLE ware_article
(
    art_id BIGINT NOT NULL AUTO_INCREMENT  COMMENT 'article id',
    name VARCHAR(200) COMMENT 'article name',
    PRIMARY KEY (art_id)
);

ALTER TABLE ware_article COMMENT 'Article Information';

/*==============================================================*/
/* Table: ware_ware_order_task                                  */
/*==============================================================*/
DROP TABLE IF EXISTS ware_order_task;

CREATE TABLE ware_order_task
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
ALTER TABLE ware_order_task COMMENT 'Ware Order Task';

/*==============================================================*/
/* Table: ware_order_task_item                            */
/*==============================================================*/
DROP TABLE IF EXISTS ware_order_task_item;

CREATE TABLE ware_order_task_item
(
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    order_id BIGINT COMMENT 'order_id',
    product_id BIGINT COMMENT 'product_id',
    quantity INT COMMENT 'quantity',
    task_item_status TINYINT(8)  COMMENT 'task item status',
    originated DATETIME COMMENT 'timestamp to lock the stock',
    modified DATETIME DEFAULT now() COMMENT 'modified',
    PRIMARY KEY (id)
);

ALTER TABLE ware_order_task_item COMMENT 'Ware Order Task Item';

/*==============================================================*/
/* Table: ware_order_task_item_article                            */
/*==============================================================*/
DROP TABLE IF EXISTS ware_order_task_item_article;

CREATE TABLE ware_order_task_item_article
(
    id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
    product_id BIGINT COMMENT 'product_id',
    art_id BIGINT COMMENT 'art_id',
    quantity INT COMMENT 'quantity',
    task_item_status TINYINT(8)  COMMENT 'task item status',
    originated DATETIME COMMENT 'timestamp to lock the stock',
    modified DATETIME DEFAULT now() COMMENT 'modified',
    PRIMARY KEY (id)
);

ALTER TABLE ware_order_task_item_article COMMENT 'Ware Order Task Item Article';