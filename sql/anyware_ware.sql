-- DROP DATABASE IF EXISTS anyware_ware;

DROP TABLE IF EXISTS ware_sku;

DROP TABLE IF EXISTS ware_article;

CREATE TABLE ware_sku
(
    id bigint not null auto_increment comment 'id',
    art_id bigint comment 'article id',
    name VARCHAR(200) comment 'article name',
    stock int comment 'stock',
    deleted tinyint default 1 comment 'status',
    PRIMARY KEY (id)
);
alter table ware_sku comment 'Inventory Information';

CREATE TABLE ware_article
(
    art_id bigint not null auto_increment  comment 'article id',
    name VARCHAR(200) comment 'article name',
    PRIMARY KEY (art_id)
);

alter table ware_article comment 'Article Information';