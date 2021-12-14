DROP DATABASE IF EXISTS anyware_product;
USE anyware_product;
/*==============================================================*/
/* Table: ware_product                                          */
/*==============================================================*/
DROP TABLE IF EXISTS ware_sku;

CREATE TABLE ware_product
(
    id bigint not null auto_increment COMMENT 'id',
    name VARCHAR(200) not null COMMENT 'article name',
--    deleted tinyint not null default 1 COMMENT 'status',
    PRIMARY KEY (id),
    CONSTRAINT unique_name UNIQUE (name)
);

ALTER TABLE ware_product COMMENT 'Product Information';
/*==============================================================*/
/* Table: ware_product_article_relation                         */
/*==============================================================*/
DROP TABLE IF EXISTS ware_product_article_relation;

CREATE TABLE ware_product_article_relation
(
    id bigint not null auto_increment COMMENT 'id',
    product_id bigint not null COMMENT "product id",
    art_id bigint not null COMMENT "article id",
    amount_of bigint not null default 0 COMMENT "amount of articles for product",
--    deleted tinyint not null default 1 COMMENT 'status',
    PRIMARY KEY (id),
    CONSTRAINT unique_name UNIQUE (product_id,art_id)
);

ALTER TABLE ware_product_article_relation COMMENT 'Product Article Information';

